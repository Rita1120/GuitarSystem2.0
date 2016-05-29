package guitar.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	private static final String DBDRIVER = "org.sqlite.JDBC";
	private static final String DBURL="jdbc:sqlite://e:/sqlitedata/instrument2.db";
	static Connection conn=null;
	public static Connection getConnection(){
		
	  try{
		 Class.forName(DBDRIVER);	
		 conn=DriverManager.getConnection(DBURL);
		}catch(ClassNotFoundException e){
			
		}		
		catch (SQLException e) {
			e.printStackTrace();
			System.out.print("sql error");
		}
		
		return conn;
}
}