package wordDictation.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbutilforYasiBook {
	private String dbURL = "jdbc:sqlite:C:\\Users\\��Ӻ��\\PycharmProjects\\danei\\weibospider\\javatool\\javaprojectYaSiBook.db";
	private String dbUserName = "root";
	private String dbPassword = "123456";
	private String jdbcName = "org.sqlite.JDBC";
	
	/***
	 * ��ȡ���ݿ�����
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
			System.out.println("���ݿ����ӳɹ�");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
