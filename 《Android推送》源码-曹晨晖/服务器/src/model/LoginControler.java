package model;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;


import org.apache.mina.core.session.IoSession;

import sun.applet.Main;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import com.sun.xml.internal.ws.util.UtilException;

import DBHelper.DBManaer;
import Interface.Observer;
import Interface.Pulisher;

/**
 * 用户连接model，包括操作添加新session，获取当前所有session，更新session时间，寻找session
 * 
 * @author 晨晖
 * 
 */
public class LoginControler implements Pulisher {
	public static String ADD_NEW_USER = "INSERT INTO users (uuid,username,create_time,last_connect_time)VALUES(\'%s\', \'%s\', \'%s\', \'%s\')";
	public static String SREACH_USER_BY_UUID = "select * from users where uuid = \'%s\';";
	public static String UPDATE_USER_CONN_TIME = "UPDATE users SET last_connect_time = \'%s\' where uuid = \'%s\';";
	public static String GET_ALL_USER = "select * from users;";
	private ArrayList<Observer> observers;

	private static LoginControler controler = null;

	private LoginControler() {
		observers = new ArrayList<Observer>();
	}

	public static LoginControler getInstance() {
		if (controler == null) {
			controler = new LoginControler();
		}
		return controler;
	}

	public void addNewConnector(Connector connector) {
		Connection conn = null;
		Statement statement = null;
		boolean result = false;
		try {
			conn = DBManaer.getDBConnection();
			statement = conn.createStatement();
			statement.executeUpdate(String.format(ADD_NEW_USER, connector
					.getUuid(), connector.getName(), connector.getCreateTime()
					.toString(), connector.getLastConnTime().toString()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManaer.releaseDBConnection(conn, null, statement);
		}
	}

	public ArrayList<Connector> getAllConnector() {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Connector> allUser = new ArrayList<Connector>();
		try {
			conn = DBManaer.getDBConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(GET_ALL_USER);
			while (resultSet.next()) {
				allUser.add(new Connector(resultSet.getString(1), resultSet
						.getString(2), new Timestamp(resultSet.getDate(3)
						.getTime()) ,new Timestamp(resultSet.getDate(4)
								.getTime()),false,null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManaer.releaseDBConnection(conn, resultSet, statement);
		}
		return allUser;
	}

//	public Connector findSessionByUuid(String uuid) {
//		Connection conn = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		Connector resUser = null;
//		try {
//			conn = DBManaer.getDBConnection();
//			statement = conn.createStatement();
//			resultSet = statement.executeQuery(String.format(
//					SREACH_USER_BY_UUID, uuid));
//			if (resultSet.next()) {
//				resUser = Connector
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBManaer.releaseDBConnection(conn, resultSet, statement);
//		}
//		return resUser;
//	}

	public boolean updateSessionConnTime(Connector connector) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			conn = DBManaer.getDBConnection();
			statement = conn.createStatement();
			result = statement.executeUpdate(String.format(
					UPDATE_USER_CONN_TIME, connector.getLastConnTime(), connector.getUuid()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManaer.releaseDBConnection(conn, resultSet, statement);
		}
		// notifyAllObserver();
		if (result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyAllObserver() {
		// TODO Auto-generated method stub
		for (Observer ob : observers) {
			ob.update();
		}
	}

}
