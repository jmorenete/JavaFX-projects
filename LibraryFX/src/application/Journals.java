package application;

import java.util.Scanner;

public class Journals extends Items{
	
	private String subject;
	private String journalId;



	public Journals(String name,String subject, int pageNo, double location) {
		super(name, pageNo, location);
		this.subject = subject;
		this.journalId =("J" + Items.itemNo);

		items.add(this);
	}

	public String getJournalId() {
		return journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int loanTime() {
		// TODO Auto-generated method stub
		return 14;
	}
//	public String addItem() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter name, subject, number of pages and location of book: ");
//		String journalname = sc.nextLine();
//		String subject = sc.nextLine();
//		int pageno = sc.nextInt();
//		int location = sc.nextInt();
//		
//		new Journals(journalname, subject, pageno,location); //how can i access the id?
//		
//		return "Journal: " + journalname + "added to library with id: ";
//	}

}
