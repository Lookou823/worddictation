package wordDictation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import wordDictation.model.selfWord;
import wordDictation.util.StringUtil;

/**
 * 
 * 
 * 自定义录入Dao类
 * @author 留雍迪
 *
 */
public class selfWordDao {
	/**
	 * 单词录入
	 * @param con
	 * @param selfWord
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,selfWord selfWord,String username,String date)throws Exception{
		String sql = "insert into selfwords values(null,?,?,?,?)";
		PreparedStatement pstmt =  con.prepareStatement(sql);
		pstmt.setString(1, selfWord.getWord());
		pstmt.setString(2, selfWord.getWordExp());
		pstmt.setString(3, username);
		pstmt.setString(4, date);

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
	public static ResultSet list(Connection con,String logusername,String date)throws Exception{

		StringBuffer sb = new StringBuffer("select * from selfwords");

		sb.append(" and userName like '%"+logusername+"%'");
		sb.append(" and changeDate like '%"+date+"%'");

		
		
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	/**
	 * 删除录入的单词
	 * @param con
	 * @param num
	 * @return
	 * @throws Exception
	 */
	
	public static int delete(Connection con,int num)throws Exception{
		String sql="delete from selfwords where num =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		return pstmt.executeUpdate();
		
	}
	/**
	 * 更新单词
	 * @param con
	 * @param selfWord
	 * @return
	 * @throws Exception
	 */
	public static int update(Connection con,selfWord selfWord)throws Exception{
		String sql="update selfwords set word=?,wordExp=? where num=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, selfWord.getWord());
		pstmt.setString(2, selfWord.getWordExp());
		pstmt.setInt(3,selfWord.getNum());
		return pstmt.executeUpdate();
		
	}
	
	public static ResultSet listforchange(Connection con,selfWord selfWord)throws Exception{

		StringBuffer sb = new StringBuffer("select * from selfwords");
		if(StringUtil.isNotEmpty(selfWord.getChangeDate())) {
			sb.append(" and changeDate like '%"+selfWord.getChangeDate()+"%'");
			
		}
		if(StringUtil.isNotEmpty(selfWord.getOwerUser())) {
			sb.append(" and userName like '%"+selfWord.getOwerUser()+"%'");
			
		}
		
		
		
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}


}
