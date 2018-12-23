package application;

import java.util.Scanner;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;

public class Books extends Items {
	private String genre;	
	private String bookId;
	
	public Books(String name, String genre,int pageNo, double location) {
		super(name, pageNo, location);
		this.genre = genre;
		this.bookId = ("B"+ Items.itemNo);
		items.add(this);
	}
	
	
	@Override
	public int loanTime() {
		return 20;

	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
//
//	public String addItem() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter name, genre, number of pages and location of book: ");
//		String bookname = sc.nextLine();
//		String genre = sc.nextLine();
//		int pageno = sc.nextInt();
//		int location = sc.nextInt();
//		
//		new Books(bookname, genre, pageno,location); //how can i access the id?
//		
//		return "Book: " + bookname + "added to library with id: ";
//	}



	
}

