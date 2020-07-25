package wordDictation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import wordDictation.model.book;
import wordDictation.util.StringUtil;

public class bookDao {

	
	/**
	 * 查询所有的雅思书
	 * @param con
	 * @param s_username
	 * @return
	 * @throws Exception
	 */
	public static ResultSet list(Connection con,book book)throws Exception{
		StringBuffer sb = new StringBuffer("select * from book_name");
		if(!StringUtil.isEmpty(book.getBookName()) )
			sb.append(" and name like '%"+book.getBookName()+"%'");
		
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();		
	}
	
	/**
	 * 查询这本书所有的单元
	 */
	
	public static ResultSet listUnit(Connection con,String bookname)throws Exception{
		StringBuffer sb = new StringBuffer("select * from book_unit");
		if(!StringUtil.isEmpty(bookname) )
			sb.append(" and bookname like '%"+bookname+"%'");
		
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();		
	}
	
	/**
	 * 查询这本书这个单元的单词数
	 */
	
	public static ResultSet listWord(Connection con,String bookname,String unitname)throws Exception{
		StringBuffer sb = new StringBuffer("select * from book_word");
		if(!StringUtil.isEmpty(bookname) )
			sb.append(" and bookname like '%"+bookname+"%'");
		if(!StringUtil.isEmpty(unitname) )
			sb.append(" and unit like '%"+unitname+"%'");
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();		
	}
	
	/**
	 * 查询这本书这个单元的单词数
	 */
	
	public static ResultSet listWordLimit(Connection con,String bookname,String unitname,int begin,int end)throws Exception{
		String num1 = String.valueOf(begin);
		String num2 = String.valueOf(end-1);

		StringBuffer sb = new StringBuffer("select * from book_word");
		if(!StringUtil.isEmpty(bookname) )
			sb.append(" and bookname like '%"+bookname+"%'");
		if(!StringUtil.isEmpty(unitname) )
			sb.append(" and unit like '%"+unitname+"%'");
		
			sb.append(" and  id between "+num1+" and "+num2);
		PreparedStatement pstmt =  con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();		
	}
	
	
	
}
