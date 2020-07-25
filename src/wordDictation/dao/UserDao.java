package wordDictation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import wordDictation.model.User;


/**
 * 
 * 用户dao类
 * @author 留雍迪
 *
 */
public class UserDao {

	
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */

	
	public User login(Connection con,User user)throws Exception {
		User resultUser = null;
		String sql = "select * from user_table where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassWord());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setUserPassWord(rs.getString("password"));
			
			
		}
		return resultUser;
	
	}

}
