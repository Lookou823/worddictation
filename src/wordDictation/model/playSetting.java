package wordDictation.model;

public class playSetting {
	private int readingtimes;
	private int intervaltime;
	private String s_username;
	private int num;
	
	
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public playSetting() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public playSetting(int readingtimes, int intervaltime, String s_username, int num) {
		super();
		this.readingtimes = readingtimes;
		this.intervaltime = intervaltime;
		this.s_username = s_username;
		this.num = num;
	}

	public int getReadingtimes() {
		return readingtimes;
	}
	public void setReadingtimes(int readingtimes) {
		this.readingtimes = readingtimes;
	}
	public int getIntervaltime() {
		return intervaltime;
	}
	public void setIntervaltime(int intervaltime) {
		this.intervaltime = intervaltime;
	}
	public String getS_username() {
		return s_username;
	}
	public void setS_username(String s_username) {
		this.s_username = s_username;
	}
	
	
	
	
}
