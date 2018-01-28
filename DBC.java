package ch12_151304064_151304094;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	static Connection conn=null;
	private static String username="root";
	private static String password="root";
	private static String driverClassName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/student";
	
	public Connection getConnection(){
		try{
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(url,username,password);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(){
		if(conn!=null){
			try{
				conn.close();
			}
			catch (SQLException e){
				System.out.println("Î´Á¬½Ó");
				e.printStackTrace();
			}
		}
	}
	
	
}
