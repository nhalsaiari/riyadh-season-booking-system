package projectcsc;

import java.util.Scanner;

public class RiyadhSeasonBooking {
    public static void main(String[] args) {
    	// VARIABLES
        Scanner scanner = new Scanner(System.in);
        String event1 = "Boulevard World", event2 = "Boulevard City", event3 = "Wonder Garden", event4 = "Boulevard Runway";
        int event1Price = 153, event2Price = 25, event3Price = 254, event4Price = 110;
        int event1Profit = 0, event1counter=0, event2Profit = 0, event2counter=0, event3Profit = 0, event3counter=0, event4Profit = 0, event4counter=0;
        String event1Booked = "", event2Booked = "", event3Booked = "", event4Booked = "";
        int TotalProfit = event1Profit + event2Profit + event3Profit + event4Profit;
        String Booked = event1Booked + "\n" + event2Booked + "\n" + event3Booked + "\n" + event4Booked;
        int year, month = 0, choice;
        String customerID;
        // WELCOME MESSAGE
        System.out.println("Welcome to the Riyadh Season Ticket Booking System!");
        
        
        Event Event1 = new Event("Boulevard World", "E1", 153);
        
        // YEAR AND MONTH 
        do {
            System.out.print("Please enter the year for booking: ");
            year = scanner.nextInt();

            if (year < 2024) {
                System.out.println("Invalid year input. Please enter 2024 or later.");
            } else {
                if (year == 2024) {
                    do {
                        System.out.print("Please enter the month for booking: ");
                        month = scanner.nextInt();
                        if (month < 10 || month > 12) {
                            System.out.println("Invalid month for 2024. Please enter a valid month (10-12).");
                        }
                    } while (month < 10 || month > 12);
                } else if (year > 2024) {
                    do {
                        System.out.print("Please enter the month for booking: ");
                        month = scanner.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.println("Invalid month. Please enter a valid month.");
                        }
                    } while (month < 1 || month > 12); 
                }
            }
        } while (year < 2024);

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        // MAIN MENU
        do {
            System.out.println("\nMain Menu");
            System.out.println("1. Manager Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");

            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

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
                    managerChoice = scanner.nextInt();

                    switch (managerChoice) {
                        case 1:
                            if (TotalProfit != 0) {
                                System.out.println("Event booked:\n " + Booked);
                            } else {
                                System.out.println("No events are currently booked.");
                            }
                            break;

                        case 2:
                            System.out.println("\n Events:");
                            System.out.println("1. Boulevard World");
                            System.out.println("2. Boulevard City");
                            System.out.println("3. Wonder Garden");
                            System.out.println("4. Boulevard Runway");
                            System.out.print("Enter the event number: ");
                            int searchEvent = scanner.nextInt();
                            //DISPLAY BOOKING OF A SPICIFIC EVENT
                            if (TotalProfit != 0 && searchEvent == 1) {
                                System.out.println("Booking found for: " + event1 + "\n" + event1Booked);
                            } else if (TotalProfit != 0 && searchEvent == 2) {
                                System.out.println("Booking found for: " + event2 + "\n" + event2Booked);
                            } else if (TotalProfit != 0 && searchEvent == 3) {
                                System.out.println("Booking found for: " + event3 + "\n" + event3Booked);
                            } else if (TotalProfit != 0 && searchEvent == 4) {
                                System.out.println("Booking found for: " + event4 + "\n" + event4Booked);
                            } else {
                                System.out.println("No booking found for that event.");
                            }
                            break;

                        case 3:
                            System.out.println("Total profits: " + TotalProfit);
                            break;

                        case 4:
                            System.out.println("\n Events:");
                            System.out.println("1. Boulevard World");
                            System.out.println("2. Boulevard City");
                            System.out.println("3. Wonder Garden");
                            System.out.println("4. Boulevard Runway");
                            System.out.print("Enter the event number to display their profit: ");
                            int ProfitEvent = scanner.nextInt();
                            // DISPLAY PROFIT OF SPICIFC EVENT
                            if (TotalProfit != 0 && ProfitEvent == 1 ) {
                                System.out.println("Profit found for: " + event1 + "\n" + event1Profit);
                            } else if (TotalProfit != 0 && ProfitEvent == 2) {
                                System.out.println("Profit found for: " + event2 + "\n" + event2Profit);
                            } else if (TotalProfit != 0 && ProfitEvent == 3) {
                                System.out.println("Profit found for: " + event3 + "\n" + event3Profit);
                            } else if (TotalProfit != 0 && ProfitEvent == 4) {
                                System.out.println("Profit found for: " + event4 + "\n" + event4Profit);
                            } else {
                                System.out.println("No profits yet.");
                            }
                            break;

                        case 5:
                            System.out.println("Returning to the main menu...");
                            break;
                        default:
                        	System.out.println("Invalid option. Try again.");
                    }
                    
                } while (managerChoice != 5);

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
                    customerChoice = scanner.nextInt();

                    switch (customerChoice) {
                        case 1:
                        	System.out.println("\n Events:");
                            System.out.println("1. Boulevard World " + event1Price);
                            System.out.println("2. Boulevard City " + event2Price);
                            System.out.println("3. Wonder Garden " + event3Price);
                            System.out.println("4. Boulevard Runway " + event4Price);
                            System.out.print("Enter the event number for booking: ");
                            int BookingEvent = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter the day of the booking: ");
                            int bookingDay = scanner.nextInt();
                            // CHECK IF DATE OF BOOKING IS VAILD 
                            if (year >= 2025) {
                            	if (month == 2) {
                                    if (!isLeapYear && bookingDay > 28) {
                                        System.out.println("February in a non-leap year only has 28 days. Please enter a valid day (1-28): ");
                                        bookingDay = scanner.nextInt();
                                    } else if (isLeapYear && bookingDay > 29) {
                                        System.out.println("February in a leap year only has 29 days. Please enter a valid day (1-29): ");
                                        bookingDay = scanner.nextInt();
                                    }
                                }
                                if (year >= 2024 && ( month == 4 || month == 6 || month == 9 || month == 11)) {
                                    if (bookingDay > 30) {
                                        System.out.println("The selected month only has 30 days. Please enter a valid day (1-30): ");
                                        bookingDay = scanner.nextInt();
                                    }
                                } else if (bookingDay > 31) {
                                    System.out.println("The selected month only has 31 days. Please enter a valid day (1-31): ");
                                    bookingDay = scanner.nextInt();
                                }
                            }
                            scanner.nextLine();
                            // CHECK IF ID ENTERED IS 10 DIGITS
                            do {
                                System.out.print("Enter your 10-digit ID: ");
                                customerID = scanner.next();
                                if (customerID.length() != 10) {
                                    System.out.println("Invalid ID, try again. The ID must be exactly 10 digits.");
                                }
                            } while (customerID.length() != 10);
                            
                            scanner.nextLine();
                            System.out.print("Enter your name: ");
                            String customerName = scanner.next();
                            // CHECKING IF THE USER ALREADY BOOKED THIS EVENT BY LOOKING FOR THE ID OR THE DATE IN EACH EVENT
                                if (BookingEvent == 1) {
                                	if(event1Booked.indexOf(customerID) != -1 || event1Booked.indexOf( bookingDay+"/") != -1 ) {
                                		System.out.println("You already booked this event or this date was booked.");
                                	}else {
                                		// MAKING THE BOOKING
                                		event1Profit += event1Price;
                                        event1counter += 1;
                                        event1Booked += customerID + "-" + customerName + "-" + event1 + "-" + bookingDay + "/" + month + "/" + year + "; \n";
                                        System.out.println("Your Booking was successful!");
                                	}
                                    
                                } else if (BookingEvent == 2) {
                                	if(event1Booked.indexOf(customerID) != -1 || event2Booked.indexOf( bookingDay+"/") != -1 ) {
                                		System.out.println("You already booked this event or this date was booked.");
                                	}else {
                                		event2Profit += event2Price;
                                        event2counter += 1;
                                        event2Booked += customerID + "-" + customerName + "-" + event2 + "-" + bookingDay + "/" + month + "/" + year + "; \n";
                                        System.out.println("Your Booking was successful!");
                                	}
                                    
                                } else if (BookingEvent == 3) {
                                	if(event1Booked.indexOf(customerID) != -1 || event3Booked.indexOf( bookingDay+"/") != -1) {
                                		System.out.println("You already booked this event or this date was booked.");
                                	}else {
                                		event3Profit += event3Price;
                                        event3counter += 1;
                                        event3Booked += customerID + "-" + customerName + "-" + event3 + "-" + bookingDay + "/" + month + "/" + year + "; \n";
                                        System.out.println("Your Booking was successful!");
                                	}
                                    
                                } else if (BookingEvent == 4) {
                                	if(event1Booked.indexOf(customerID) != -1 || event4Booked.indexOf( bookingDay+"/") != -1) {
                                		System.out.println("You already booked this event or this date was booked.");
                                	}else {
                                		event4Profit += event4Price;
                                        event4counter += 1;
                                        event4Booked += customerID + "-" + customerName + "-" + event4 + "-" + bookingDay + "/" + month + "/" + year + "; \n";
                                        System.out.println("Your Booking was successful!");
                                	}
                                    
                                } else {
                                    System.out.println("Invalid input");
                                }
                                // UPDATING THE TOTAL PROFIT AND THE WHOLE BOOKING EACH TIME
                                TotalProfit = event1Profit + event2Profit + event3Profit + event4Profit;
                                Booked = event1Booked + "\n" + event2Booked + "\n" + event3Booked + "\n" + event4Booked;
                            
                            break;
                            
                        case 2:
                        	System.out.println("\n Events:");
                            System.out.println("1. Boulevard World");
                            System.out.println("2. Boulevard City");
                            System.out.println("3. Wonder Garden");
                            System.out.println("4. Boulevard Runway");
                            System.out.print("Enter the event number of your booking: ");
                            int CancelEvent = scanner.nextInt();
                        	if(TotalProfit != 0) {
                        		System.out.print("Enter Your ID to cancel your booking:");
                        		customerID =scanner.next();
                        		// LOOKING FOR THE BOOKING IN EACH EVENT SEPARATELY 
                        		if (CancelEvent==1) {
                        			// LOOK IF THE ID IS IN THIS EVENT
                        			if (event1Booked.indexOf(customerID) != -1){
                        				// GET THE START AND THE END OF THE STRING OF THE BOOKING AND REPLACE IT WITH AN EMPTY STRING
                            			int start = event1Booked.indexOf(customerID);
                            			int end = event1Booked.indexOf(";", start) + 1;
                            			String bookingToRemove = event1Booked.substring(start, end);
                            			event1Booked = event1Booked.replace(bookingToRemove, "");
                            			System.out.println("Your booking for Boulevard World has been successfully canceled.");
                            			//UPDATE
                            			event1counter=event1counter-1;
                            			event1Profit=event1Profit-event1Price;}
                        			else { System.out.print("You have no booking for this event");}
                        			
                        	}else if(CancelEvent==2) {
                        		if (event2Booked.indexOf(customerID) != -1) {
                        			int start = event2Booked.indexOf(customerID);
                        			int end = event2Booked.indexOf(";", start) + 1;
                        			String bookingToRemove = event2Booked.substring(start, end);
                        			event2Booked = event2Booked.replace(bookingToRemove, "");
                        			System.out.println("Your booking for Boulevard City has been successfully canceled.");
                        			event2counter=event2counter-1;
                        			event2Profit=event2Profit-event2Price;
                        		}else { System.out.print("You have no booking for this event");}
                        		
                        	}else if(CancelEvent==3) {
                        		if (event3Booked.indexOf(customerID) != -1) {
                        			int start = event3Booked.indexOf(customerID);
                        			int end = event3Booked.indexOf(";", start) + 1;
                        			String bookingToRemove = event3Booked.substring(start, end);
                        			event3Booked = event3Booked.replace(bookingToRemove, "");
                        			System.out.println("Your booking for Wonder Garden has been successfully canceled.");
                        			event3counter=event3counter-1;
                        			event3Profit=event3Profit-event3Price;}
                        		else { System.out.print("You have no booking for this event");}
                        		
                        	}else if(CancelEvent==4) {
                        		if (event4Booked.indexOf(customerID) != -1) {
                        			int start = event4Booked.indexOf(customerID);
                        			int end = event4Booked.indexOf(";", start) + 1;
                        			String bookingToRemove = event4Booked.substring(start, end);
                        			event4Booked = event4Booked.replace(bookingToRemove, "");
                        			System.out.println("Your booking for Boulevard Runway has been successfully canceled.");
                        			event4counter=event4counter-1;
                        			event4Profit=event4Profit-event4Price;}
                        		else { System.out.print("You have no booking for this event");}
                        	}else {
                        			System.out.print("Your ID has not been found.");}}
                        	else {System .out.print("There is no booking to cancel.");}
                        	TotalProfit = event1Profit + event2Profit + event3Profit + event4Profit;
                            Booked = event1Booked + "\n" + event2Booked + "\n" + event3Booked + "\n" + event4Booked;
                        	break;
                        	
                        case 3:
                        	if(TotalProfit != 0) {
                        		int max = event1counter;
                        		String PopularEvent = event1;
                        		if(event2counter > max) { max= event2counter; PopularEvent =event2; }
                        		if(event3counter > max) { max= event3counter; PopularEvent=event3;}
                        		if(event4counter > max) { max= event4counter; PopularEvent=event4;}
                        		System.out.print("The most popular event is: " + PopularEvent);}
                        	else {System.out.print("There is no popular event yet.");}
                        	break;

                        case 4:
                            System.out.println("Returning to the main menu...");
                            break;
                       default:
                        	System.out.println("Invalid option. Try again.");
                    }
                } while (customerChoice != 4);
            } else if (choice == 3) {
                System.out.println("Thank you for using the Riyadh Season Ticket Booking System!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        } while (true);
    }}
	  
	               
   
