package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBManaer {
	static String dbUrl = "jdbc:mysql://localhost:3307/androidpn";
	static String dbUserName = "root";
	static String dbPassword = "123456";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("errow:���ݿ���������ʧ��");
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection() throws SQLException {
		return (Connection)DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
	}

	public static void releaseDBConnection(Connection connection,
			ResultSet resultSet, Statement statement) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("errow:ResultSet������ͷ�ʧ��");
				e.printStackTrace();
			}finally{
				resultSet = null;
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("errow:Statement�ͷ�ʧ��");
				e.printStackTrace();
			}finally{
				statement = null;
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("errow:Connection���ݿ������ͷ�ʧ��");
				e.printStackTrace();
			}finally{
				connection = null;
			}
		}
	}
	
	public static Timestamp getCurTimeInDate(){
        Timestamp goodsC_date = new Timestamp(System.currentTimeMillis());
        return goodsC_date;
	}
	
}
