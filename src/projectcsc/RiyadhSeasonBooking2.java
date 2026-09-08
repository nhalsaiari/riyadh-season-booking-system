package projectcsc;

import java.util.Scanner;

public class RiyadhSeasonBooking2 {
	public static void main (String [] args) {
		// VARIABLES
		Scanner keyboard = new Scanner (System.in);
		int year, month = 0, choice;
        String customerID;
		
		// WELCOME MESSAGE
        System.out.println("Welcome to the Riyadh Season Ticket Booking System!");
        
        // OBJECTS FOR EACH EVENT 
        Event event1 = new Event("Boulevard World", "E1", 153);
        Event event2 = new Event("Boulevard City", "E2", 25);
        Event event3 = new Event("Wonder Garden", "E3", 254);
        Event event4 = new Event("Boulevard Runway", "E4", 110);
        
        System.out.println("*Number of Events:* " + Event.EventCounter);
        
        // YEAR AND MONTH
        do {
            System.out.print("Please enter the year for booking: ");
            year = keyboard.nextInt();

            if (year < 2024) {
                System.out.println("Invalid year input. Please enter 2024 or later.");
            } else {
                if (year == 2024) {
                    do {
                        System.out.print("Please enter the month for booking: ");
                        month = keyboard.nextInt();
                        if (month < 11 || month > 12) {
                            System.out.println("Invalid month for 2024. Please enter a valid month (11-12).");
                        }
                    } while (month < 10 || month > 12);
                } else {
                    do {
                        System.out.print("Please enter the month for booking: ");
                        month = keyboard.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.println("Invalid month. Please enter a valid month.");
                        }
                    } while (month < 1 || month > 12);
                }
            }
        } while (year < 2024);
        
        
        // MAIN MENU
        do {
        	 System.out.println("\nMain Menu");
             System.out.println("1. Manager Menu");
             System.out.println("2. Customer Menu");
             System.out.println("3. Exit");

             System.out.print("Please choose an option: ");
             choice = keyboard.nextInt();

             if (choice == 1) {
             	int managerChoice;
             	
             	// MANAGER MENU
             	do {
             		 System.out.println("\nManager Menu:");
                     System.out.println("1. View All Booking Information");
                     System.out.println("2. View Specific Event Booking Details");
                     System.out.println("3. View Overall Profits");
                     System.out.println("4. View Profit for a Specific Event");
                     System.out.println("5. Return to Main Menu");
                     System.out.print("Choose an option: ");
                     managerChoice = keyboard.nextInt();
                     
                     switch (managerChoice) {
                     case 1:
                         event1.printInfo();
                         event2.printInfo();
                         event3.printInfo();
                         event4.printInfo();
                         break;
                         
                     case 2:
                    	 
                    	 System.out.println("\n Events:");
                         System.out.println("1. Boulevard World");
                         System.out.println("2. Boulevard City");
                         System.out.println("3. Wonder Garden");
                         System.out.println("4. Boulevard Runway");
                         System.out.print("Enter the event number: ");
                         int searchEvent = keyboard.nextInt();
                         
                         //DISPLAY BOOKING OF A SPICIFIC EVENT
                         if (searchEvent == 1) {
                        	 event1.printInfo();
                         } else if (searchEvent == 2) {
                        	 event2.printInfo();
                         } else if (searchEvent == 3) {
                        	 event3.printInfo();
                         } else if (searchEvent == 4) {
                        	 event4.printInfo();
                         } else {
                        	 System.out.println("Invalid Input.");
                         }
                         break;
                         
                     case 3:
                    	 System.out.println("Total profit:" + Event.getTotalProfit());
                    	 break;
                    
                     case 4: 
                    	 System.out.println("\n Events:");
                         System.out.println("1. Boulevard World");
                         System.out.println("2. Boulevard City");
                         System.out.println("3. Wonder Garden");
                         System.out.println("4. Boulevard Runway");
                         System.out.print("Enter the event number to display their profit: ");
                         int ProfitEvent = keyboard.nextInt();
                         
                         // DISPLAY PROFIT OF SPICIFC EVENT
                         if (event1.getEventProfit() != 0 && ProfitEvent == 1 ) {
                             System.out.println("Profit found for Boulevard World: " + event1.getEventProfit());
                         } else if (event2.getEventProfit() != 0 && ProfitEvent == 2) {
                             System.out.println("Profit found for Boulevard City: " +  event2.getEventProfit());
                         } else if (event3.getEventProfit() != 0 && ProfitEvent == 3) {
                             System.out.println("Profit found for Wonder Garden: " + event3.getEventProfit());
                         } else if (event3.getEventProfit() != 0 && ProfitEvent == 4) {
                             System.out.println("Profit found for Boulevard Runway: " + event4.getEventProfit());
                         } else {
                             System.out.println("No profits yet for this event.");
                         }
                         break;
                         
                     case 5:
                         System.out.println("Returning to the main menu...");
                         break;
                     default:
                     	System.out.println("Invalid option. Try again."); 	 
                   }}while (managerChoice != 5); // END OF MANAGER MENU
             	
             	
             	
             	
              } else if (choice == 2) {
            	  int customerChoice;
              	//CUSTOMER MENU
            	  
            	  do {
            		  System.out.println("\nCustomer Menu:");
                      System.out.println("1. Book an Event Ticket");
                      System.out.println("2. Cancel a Booking");
                      System.out.println("3. View Most Popular Event");
                      System.out.println("4. Return to Main Menu");
                      System.out.print("Choose an option: ");
                      customerChoice = keyboard.nextInt();
                      
                      switch (customerChoice) {
                      case 1 :
                          System.out.println("\nEvents:");
                          System.out.println("1. Boulevard World ");
                          System.out.println("2. Boulevard City" );
                          System.out.println("3. Wonder Garden" );
                          System.out.println("4. Boulevard Runway ");
                          System.out.print("Enter the event number for booking: ");
                          int bookingEvent = keyboard.nextInt();

                          System.out.print("Enter your 10-digit ID: ");
                          customerID = keyboard.next();
                          System.out.print("Enter your name: ");
                          String customerName = keyboard.next();
                          int bookingDay;
                          do {
                              System.out.print("Enter the day of booking: ");
                              bookingDay = keyboard.nextInt();
                              if (!isValid(bookingDay, month, year)) {
                                  System.out.println("Invalid booking date. Please enter a valid day.");
                              }
                              
                          } while (!isValid(bookingDay, month, year));
                          
                          boolean bookingSuccess;
                          if (bookingEvent == 1) {
                              bookingSuccess = event1.Book(customerID, customerName, bookingDay, month, year);
                          } else if (bookingEvent == 2) {
                              bookingSuccess = event2.Book(customerID, customerName, bookingDay, month, year);
                          } else if (bookingEvent == 3) {
                              bookingSuccess = event3.Book(customerID, customerName, bookingDay, month, year);
                          } else if (bookingEvent == 4) {
                              bookingSuccess = event4.Book(customerID, customerName, bookingDay, month, year);
                          } else {
                              System.out.println("Invalid event number.");
                              bookingSuccess = false;
                          }
                          
                          if (bookingSuccess) {
                              System.out.println("Your booking was successful!");
                          } else {
                              System.out.println("Booking failed. The date may already be booked.");
                          } break;
                          
                          
                      case 2:
                      	System.out.println("\n Events:");
                          System.out.println("1. Boulevard World");
                          System.out.println("2. Boulevard City");
                          System.out.println("3. Wonder Garden");
                          System.out.println("4. Boulevard Runway");
                          System.out.print("Enter the event number you want to cancel: ");
                          int CancelEvent = keyboard.nextInt();
                          
                          System.out.print("Enter your Customer ID to cancel the booking: ");
                          customerID = keyboard.next();
                          System.out.print("Enter the day of the booking you want to cancel: ");
                          int cancelDay = keyboard.nextInt();
                          
                          boolean cancelSuccess;
                          
                          if (CancelEvent == 1) {
                        	  cancelSuccess = event1.Cancel(customerID, cancelDay, month, year);
                          } else if (CancelEvent == 2) {
                        	  cancelSuccess = event2.Cancel(customerID, cancelDay, month, year);
                          } else if (CancelEvent == 3) {
                        	  cancelSuccess = event3.Cancel(customerID, cancelDay, month, year);
                          } else if (CancelEvent == 4) {
                        	  cancelSuccess = event4.Cancel(customerID, cancelDay, month, year);
                          } else {
                              System.out.println("Invalid event number.");
                              cancelSuccess = false;
                          }
                          
                          if (cancelSuccess) {
                              System.out.println("Your booking was successfully canceled.");
                          } else {
                              System.out.println("Cancellation failed. No matching booking found.");
                          }break;
                          
                      
                      case 3: 
                    	  getPopularEvent(event1 , event2 , event3 , event4);
                    	  break;
                    	  
                      case 4: 
                    	  System.out.println("Returning to the main menu...");
                          break;
                     default:
                      	System.out.println("Invalid option. Try again.");
                    
                      }}while (customerChoice != 4); // END OF CUSROMER MENU
            	  
            	  
              } else if (choice == 3) {
                  System.out.println("Thank you for using the Riyadh Season Ticket Booking System!");
                  break;
              } else {
                  System.out.println("Invalid option. Try again.");
              } // END OF MAIN MENU 
        
	}while (true);

}
        // LEAP YEAR
        public static boolean isLeap(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        // IS DAY VAILD 
        public static boolean isValid(int day, int month, int year) {
            int daysInMonth = getNumberOfDays(month, year);
            return day >= 1 && day <= daysInMonth;
        }

        // NUMBER OF DAYS IN A MONTH
        public static int getNumberOfDays(int month, int year) {
        	 if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        	        return 31;
        	    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
        	        return 30;
        	    } else if (month == 2) {
        	        return isLeap(year) ? 29 : 28;
        	    } else {
        	        return 0;
        	    }
        }

        // POPULAR EVENT
        public static void getPopularEvent(Event event1, Event event2, Event event3, Event event4) {
           Event popularItem = event1;
           int max = event1.getNumberOfBookings();
            if (event2.getNumberOfBookings() > max) { popularItem = event2; max = event2.getNumberOfBookings();}
            if (event3.getNumberOfBookings() > max) { popularItem = event3; max = event3.getNumberOfBookings();}
            if (event4.getNumberOfBookings() > max) { popularItem = event4; max = event4.getNumberOfBookings();}
            
            System.out.println("Most Popular Event:");
            if (event1.getNumberOfBookings() == max) {
            	System.out.println(event1.getEventName() + " - " + event1.getEventId() + " - " + event1.getEventPrice() + " - " + event1.getEventProfit() + " \n " );
            }
            if (event2.getNumberOfBookings() == max) {
            	System.out.println(event2.getEventName() + " - " + event2.getEventId() + " - " + event2.getEventPrice() + " - " + event2.getEventProfit() + " \n " );
            }
            if (event3.getNumberOfBookings() == max) {
            	System.out.println(event3.getEventName() + " - " + event3.getEventId() + " - " + event3.getEventPrice() + " - " + event3.getEventProfit() + " \n " );
            }
            if (event4.getNumberOfBookings() == max) {
            	System.out.println(event4.getEventName() + " - " + event4.getEventId() + " - " + event4.getEventPrice() + " - " + event4.getEventProfit() + " \n " );
            }
           
        }    
	
	}
