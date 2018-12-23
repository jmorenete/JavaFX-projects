package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAssignment {
	
	public String currentDate() {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
	    String currentdate = dateFormat.format(currentDate);
	    
	    return currentdate;
	}
	
	public String dueDate(Items item) {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
	   // String currentdate = dateFormat.format(currentDate);

	    // convert date to calendar
	    Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	    // 14 days for book loans.
	    int time = item.loanTime();
	    c.add(Calendar.DATE, time);
	    // convert calendar to date
	    Date dueDate = c.getTime();
	    String duedate= dateFormat.format(dueDate);
		return duedate;
	}
	
}
