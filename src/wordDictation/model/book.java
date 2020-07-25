package wordDictation.model;

public class book {

	private String bookName;
	private String bookunitName;
	
	
	
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public book(String bookName, String bookunitName) {
		super();
		this.bookName = bookName;
		this.bookunitName = bookunitName;
	}


	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookunitName() {
		return bookunitName;
	}
	public void setBookunitName(String bookunitName) {
		this.bookunitName = bookunitName;
	}
	
	
	
	
}
