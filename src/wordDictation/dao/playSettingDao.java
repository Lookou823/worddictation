package wordDictation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import wordDictation.model.playSetting;
import wordDictation.model.selfWord;
import wordDictation.util.StringUtil;

public class playSettingDao {

	public static int add(Connection con,wordDictation.model.playSetting playSetting)throws Exception{
		String sql = "insert into playsetting values(null,?,?,?)";
		PreparedStatement pstmt =  con.prepareStatement(sql);
		pstmt.setInt(1, playSetting.getReadingtimes());
		pstmt.setInt(2, playSetting.getIntervaltime());
		pstmt.setString(3, playSetting.getS_username());

		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询自定义录入的单词
	 * @param con
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public static ResultSet list(Connection con,String s_username)throws Exception{
		StringBuffer sb = new StringBuffer("select * from playsetting");
		
		sb.append(" and s_username like '%"+s_username+"%'");
		
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();		
	}
	
	
	/**
	 * 更新设置
	 * @param con
	 * @param selfWord
	 * @return
	 * @throws Exception
	 */
	public static int update(Connection con,playSetting playsetting)throws Exception{
		String sql="update playsetting set readingtimes=?,intervaltime=? where num=? and s_username=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, playsetting.getReadingtimes());
		pstmt.setInt(2, playsetting.getIntervaltime());
		pstmt.setInt(3, playsetting.getNum());
		pstmt.setString(4, playsetting.getS_username());

		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 删除设置记录
	 * @param con
	 * @param num
	 * @return
	 * @throws Exception
	 */
	
	public static int delete(Connection con,int num)throws Exception{
		String sql="delete from playsetting where num =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		return pstmt.executeUpdate();
		
	}
	
	
}
