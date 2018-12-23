package application;


import java.util.ArrayList;
import java.util.Scanner;


public class Library {
	
	public static ArrayList <Library> itemreg = new ArrayList<Library>();
	
	public Library(){
			
	}
	

		public String checkOut(String itemName, String issuedTo) { //make another one with just id
			DateAssignment d = new DateAssignment();//use while loop
			if(People.peoplereg.isEmpty()) {
				return "Register a user prior to checking out.";
			}
			else {
			for(int i = 0;i< People.peoplereg.size(); i++) {
				for(int j = 0;j<Items.items.size(); j++) {
					if((People.peoplereg.get(i).getName().toLowerCase().equals(issuedTo.toLowerCase()))&(Items.items.get(j).getName().toLowerCase().equals(itemName.toLowerCase()))){
						if(Items.items.get(j) instanceof Books) {
							Books bookGen =(Books)Items.items.get(j);
							if(bookGen.getName().toLowerCase().equals(itemName.toLowerCase())) {								
								bookGen.setBorrowDate(d.currentDate());
								bookGen.setDueDate(d.dueDate(bookGen));
								bookGen.setIssuedTo(People.peoplereg.get(i).getName());
								String due = bookGen.getDueDate();
								String borrow = bookGen.getBorrowDate();
								String name = People.peoplereg.get(i).getName() +" "+ People.peoplereg.get(i).getSurname()+ " ID: "+ People.peoplereg.get(i).getPersonId();
								return itemName +"\n"+"Date borrowed: " + borrow +"\n" + "Due date: " + due+"\n" + "User: "+ name+"\n";
							}

						}
						if(Items.items.get(j) instanceof Journals) {
							Journals journalGen =(Journals)Items.items.get(j);
								if(journalGen.getName().toLowerCase().equals(itemName.toLowerCase())) {
									journalGen.setBorrowDate(d.currentDate());
									journalGen.setDueDate(d.dueDate(journalGen));
									journalGen.setIssuedTo(People.peoplereg.get(i).getName());
									String due = journalGen.getDueDate();
									String borrow = journalGen.getBorrowDate();
									String name = People.peoplereg.get(i).getName() +" "+ People.peoplereg.get(i).getSurname()+ " ID: "+ People.peoplereg.get(i).getPersonId();
									return itemName +"\n"+"Date borrowed: " + borrow +"\n" + "Due date: " + due+"\n" + "User: "+ name+"\n";
								}

						}
						if(Items.items.get(j) instanceof GovtDocs) {
							GovtDocs docGen =(GovtDocs)Items.items.get(j);
								if(docGen.getName().toLowerCase().equals(itemName.toLowerCase())) {
									docGen.setBorrowDate(d.currentDate());
									docGen.setDueDate(d.dueDate(docGen));
									docGen.setIssuedTo(People.peoplereg.get(i).getName());
									String due = docGen.getDueDate();
									String borrow = docGen.getBorrowDate();									
									String name = People.peoplereg.get(i).getName() +" "+ People.peoplereg.get(i).getSurname()+ " ID: "+ People.peoplereg.get(i).getPersonId();
									return itemName +"\n"+"Date borrowed: " + borrow +"\n" + "Due date: " + due+"\n" + "User: "+ name+"\n";
								}

						}
					
					}
				}
			}
			}
			return "No item or user found in the library" +"\n";
		}
				
		public String checkIn(String itemName, String issuedTo) {
			 
			for(int i =0; i<Items.items.size();i++) {
				boolean t1 =(Items.items.get(i).getIssuedTo() != null);				
				boolean t2 = Items.items.get(i).getName().toLowerCase().equals(itemName.toLowerCase());
				boolean t3 = t2&t1;
				
				if(t3 == true) {
					boolean namematch = Items.items.get(i).getIssuedTo().toLowerCase().equals(issuedTo.toLowerCase());
	
					if(namematch == true) {
						Items.items.get(i).setIssuedTo(null);;
						Items.items.get(i).setBorrowDate(null);
						Items.items.get(i).setDueDate(null);
					
						return "Book returned";
					}
					else {
						continue;
					}
					
				}	
			}
			return "Book not checked out";
		}	
		

		public String addItem(String itemtype, String name, String itemopt, int pageno, double location) {
//			System.out.println("Please enter the type of  item you wish to add: ");
//			Scanner sc = new Scanner(System.in);
//			String itemtype = sc.nextLine();
//			boolean successful = false;
			
			if(itemtype.equals("book")) {
				//System.out.println("Enter name, genre, number of pages and location of book: ");
//				String bookname = sc.nextLine();
//				String genre = sc.nextLine();
//				int pageno = sc.nextInt();
//				int location = sc.nextInt();
//				
				new Books(name, itemopt, pageno,location); //how can i access the id?
				String id = ((Books) (Items.items.get(Items.items.size()-1))).getBookId();
				return "Book: " + name + " added to library with ID: " +id;
			}
			
			if(itemtype.equals("journal")) {
				new Journals(name, itemopt, pageno,location); //how can i access the id?
				String id = ((Journals) (Items.items.get(Items.items.size()-1))).getJournalId();
				return "Journal: " + name + "added to library with ID: " + id;
			}
			
			if(itemtype.equals("govtdoc")) {
				new GovtDocs(name, itemopt, pageno,location); //how can i access the id?
				String id = ((GovtDocs) (Items.items.get(Items.items.size()-1))).getGovtDocId();
				return "Govt docs: " + name + "added to library with ID: " + id;
			}
			else {
				return "Type of item is not in library";
			}
		}
		
		public String deleteItem(String name, String itemid) {
			boolean st = true;
			for(int i =0;i<Items.items.size();i++) {
				boolean namematch = Items.items.get(i).getName().equals(name);
				System.out.println(namematch);
				System.out.println(i);
				if(namematch == true) {
					if(Items.items.get(i) instanceof Books) {
						String books = ((Books) Items.items.get(i)).getBookId();
							if(books.equals(itemid)) {
								Items.items.remove(i);
								st = false;
								return "Book: '"+ name + "' removed.";
							}
					}		
					if(Items.items.get(i) instanceof Journals) {
						String journals = ((Journals) Items.items.get(i)).getJournalId();
						if(journals.equals(itemid)) {
							Items.items.remove(i);
							return "Journal: '"+ name+ "' removed.";
						}	
					}
					if(Items.items.get(i) instanceof GovtDocs) {
						String doc = ((GovtDocs) Items.items.get(i)).getGovtDocId();
						if(doc.equals(itemid)) {
							Items.items.remove(i);
							return "Govt. doc: '"+ name + "' removed.";
						}	
					}
				}
				
			}
			if(st = true) {
				return "Unable to found such item.";
			}
			return "";
			
		}
		

		
		public void addPerson(String name, String midname, String surname, String dob) {
			new People(name, midname,surname,dob);	
		}
		public void addPerson(String name, String surname, String dob) {
			new People(name,surname,dob);	
		}
			
		public void deletePerson(String name, String dob) {
			for(int i =0; i<People.peoplereg.size();i++) {
				if(People.peoplereg.get(i).getName().equals(name) & People.peoplereg.get(i).getDob().equals(dob)) {
					People.peoplereg.remove(i);
				}
			}
			
		}
}
					
					
					
			
		
	



