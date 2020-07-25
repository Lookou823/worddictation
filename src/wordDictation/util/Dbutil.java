package wordDictation.util;
import java.sql.Connection;
import java.sql.DriverManager;

/***
 * 数据库工具类
 * @author 留雍迪
 *
 */
public class Dbutil {

	
	private String dbURL = "jdbc:sqlite:C:\\databaselog\\dicUsers.db";
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
