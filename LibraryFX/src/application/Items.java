package application;

import java.util.ArrayList;

public abstract class Items {

	public abstract int loanTime();
	
	public static ArrayList <Items> items = new ArrayList<Items>();
	
	private int pageNo;
	private double location;
	public static int itemNo =0;
	private String borrowDate;
	private String dueDate;
	private String name;
	private String issuedTo;
	
	public Items(String name, int pageNo, double location) {
		this.name = name;
		this.pageNo = pageNo;
		this.location = location;
		itemNo++;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public double getLocation() {
		return location;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setLocation(float location) {
		this.location = location; 
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}
}
