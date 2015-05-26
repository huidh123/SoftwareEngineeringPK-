package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.mina.core.session.IoSession;

import DBHelper.DBManaer;


public class MessageControler {

	public static String ADD_MESSAGE = "insert into send_message_tb (message,send_uuid,send_time) VALUES (\'%s\',\'%s\',\'%s\');";
	public static String FIND_MESSAGE_AFTER_TIME = "SELECT * FROM send_message_tb where send_time > \'%s\' and send_uuid=\'ALL\' or send_uuid=\'%s\'  ORDER BY send_time DESC;";

	public static void addMessage(Message message) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DBManaer.getDBConnection();
			statement = conn.createStatement();
			statement.executeUpdate(String.format(ADD_MESSAGE, message
					.getMessage(), message.getUuid(), DBManaer
					.getCurTimeInDate().toString()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManaer.releaseDBConnection(conn, null, statement);
		}
	};

//	public void test(){
//		try {
//			Connection connection = DBManaer.getDBConnection();
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("连接失败");
//			e.printStackTrace();
//		}
//	}
	
	public static ArrayList<Message> getMessageAfterTime(String time,
			String uuid) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Message> resList = new ArrayList<Message>();
		if (time == null) {
			return resList;
		}
		if (uuid == null) {
			uuid = "ALL";
		}
		try {
			conn = DBManaer.getDBConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(String.format(
					FIND_MESSAGE_AFTER_TIME, time, uuid));
			while (resultSet.next()) {
				resList.add(new Message(resultSet.getString(2), resultSet
						.getString(4), resultSet.getTimestamp(3)));
			}
			System.out.println("未发送信息数量"+resList.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManaer.releaseDBConnection(conn, resultSet, statement);
		}
		return resList;
	}
}
