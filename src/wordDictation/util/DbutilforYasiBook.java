package wordDictation.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbutilforYasiBook {
	private String dbURL = "jdbc:sqlite:C:\\Users\\留雍迪\\PycharmProjects\\danei\\weibospider\\javatool\\javaprojectYaSiBook.db";
	private String dbUserName = "root";
	private String dbPassword = "123456";
	private String jdbcName = "org.sqlite.JDBC";
	
	/***
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		return con;
		
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con != null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		Dbutil dbUtil = new Dbutil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
