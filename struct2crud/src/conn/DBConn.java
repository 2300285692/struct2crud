package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=structs";
	private static final String DBUSER = "sa";
	private static final String DBPWD = "123";
	private Connection conn = null;

	public DBConn() {
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void close() throws Exception{
		if (this.conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}

