package wordDictation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * 
 * 
 * �Զ���¼�뵥��
 * @author ��Ӻ��
 *
 */
public class selfWord {

	private int num;//���
	private String word;//����
	private String wordExp;//ע��
	private String changeDate;//�޸�����
	private String owerUser;
	
	public String getOwerUser() {
		return owerUser;
	}

	public void setOwerUser(String owerUser) {
		this.owerUser = owerUser;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public selfWord() {
		super();
		// TODO Auto-generated constructor stub
	}
	




	public selfWord(String word, String wordExp, String changeDate, String owerUser) {
		super();
		this.word = word;
		this.wordExp = wordExp;
		this.changeDate = changeDate;
		this.owerUser = owerUser;
	}

	//alt shift s
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWordExp() {
		return wordExp;
	}
	public void setWordExp(String wordExp) {
		this.wordExp = wordExp;
	}

}


