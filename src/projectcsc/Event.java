package projectcsc;

public class Event {
	private String EventName , EventId , BookedInfo;
	private double EventPrice , EventProfit;
	private int TotalEvents;
	public static int EventCounter  = 0;
	public static double TotalProfit = 0;
	
	public Event() {
		this.EventName = "";
		this.EventId = "";
		this.EventPrice = 0;
		this.BookedInfo = "";
		this.EventProfit = 0;
		this.EventCounter++; 
	}
	
	public Event(String name, String id , double price) {
		this.EventName = name;
		this.EventId= id;
		this.EventPrice= price;
		this.BookedInfo = "";
		this.EventProfit = 0;
		this.EventCounter++;
	}
	
	private boolean isDateAvaliable(int day, int month, int year) {
		String Date = day + "/" + month + "/" + year;
		return !(BookedInfo.indexOf(Date) != -1);
	}
	
	public boolean Book(String CustomerID, String CustomerName, int day, int month , int year) {
		if(isDateAvaliable(day,month,year)) {
			String Date = day + "/" + month + "/" + year;
			BookedInfo += CustomerID + " - " + CustomerName + " - " + EventName + " - " + Date + " ;";
			EventProfit += EventPrice;
			TotalProfit += EventPrice;
			TotalEvents ++;
			return true;
		}
		
		return false;
		
	}
	
	public boolean Cancel(String CustomerID,int day, int month , int year) {
		String Date = day + "/" + month + "/" + year;
		boolean found = false;
		int start = BookedInfo.indexOf(CustomerID);
		while (start != -1) {
			int end = BookedInfo.indexOf(";", start);
			String SubBooking = BookedInfo.substring(start,end);
			if(SubBooking.indexOf(Date) != -1) {
				BookedInfo = BookedInfo.replace(SubBooking, "");
				EventProfit -= EventPrice;
				TotalProfit -= EventPrice;
				TotalEvents --;
				found = true;
				break;
			}
			
			start = BookedInfo.indexOf(CustomerID , end + 1);
		}
		
		return found;
	}
	
	public int getNumberOfBookings() {
		return TotalEvents;
	}
	
	public void printInfo() {
		if (EventProfit != 0) {
			System.out.println("Event Name: " + EventName);
	        System.out.println("ID: " + EventId);
	        System.out.println("Price: " + EventPrice);
	        System.out.println("Total Profit: " + TotalProfit);
	        System.out.println("Booking Information: " + BookedInfo);
	        System.out.println("Total tickets booked: " + TotalEvents);
		}else {System.out.println("There is no booking for event " + EventName);} 
		
	}
	
	public double getEventProfit() {
		return EventProfit;
	}
	
	 public static double getTotalProfit() {
	        return TotalProfit;
	    }
	 
	 
	 public static int getNumberOfItems() {
	        return EventCounter;
	        }
	 
	 
	// SETTER & GETTER

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getEventId() {
		return EventId;
	}

	public void setEventId(String eventId) {
		EventId = eventId;
	}

	public double getEventPrice() {
		return EventPrice;
	}

	public void setEventPrice(double eventPrice) {
		EventPrice = eventPrice;
	}

	public void setEventProfit(double eventProfit) {
		EventProfit = eventProfit;
	}
	 
	 
	 
	 
	 
	 
	 
}


