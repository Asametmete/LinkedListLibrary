package Projectlibrary;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		

		
	
		  Adminpanel admin = new Adminpanel();
	        Scanner scanner = new Scanner(System.in);

	        boolean running = true;
	        while (running) {
	            // Show menu
	            System.out.println("**** Library Management System ****");
	            System.out.println("1. Add Book");
	            System.out.println("2. Remove book");
	            System.out.println("3. Add User");
	            System.out.println("4. Assign Book to User");
	            System.out.println("5. Remove Book from User");
	            System.out.println("6. User Book List");
	            System.out.println("7. Book İnfo");
	            System.out.println("8. Exit");
	            System.out.println("Please select an option (1-8):");

	            // Get user's choice
	            int choice = getUserChoice(scanner);

	            switch (choice) {
	                case 1:
	                    System.out.println("Book Title: ");
	                    String bookName = scanner.nextLine();
	                    System.out.println("Author: ");
	                    String author = scanner.nextLine();
	                    System.out.println("Genre: ");
	                    String genre = scanner.nextLine();
	                    admin.insertbook(bookName, author, genre);
	                    break;
	                case 2:
	                    System.out.println("Name of the Book to be deleted: ");
	                    String bookToDelete = scanner.nextLine();
	                    admin.remove(bookToDelete);
	                    break;
	                case 3:
	                    System.out.println("Username: ");
	                    String username = scanner.nextLine();
	                    admin.Signup(username);
	                    break;
	                case 4:
	                    System.out.println("Username: ");
	                    String user = scanner.nextLine();
	                    System.out.println("Book Title: ");
	                    String book = scanner.nextLine();
	                    admin.insertuserbook(user, book);
	                    break;
	                case 5:
	                    System.out.println("Username: ");
	                    String userToRemoveBook = scanner.nextLine();
	                    System.out.println("Name of the Book to be deleted: ");
	                    String bookToRemove = scanner.nextLine();
	                    admin.removeuserbook(userToRemoveBook, bookToRemove);
	                    break;
	                case 6:
	                    System.out.println("Username ");
	                    String userToDisplayBooks = scanner.nextLine();
	                    admin.printlist(userToDisplayBooks);
	                    break;
	                case 7:
	                	System.out.println("Book Title: ");
	                	String userToDisplayBookInfo = scanner.nextLine();
	                	admin.infobook(userToDisplayBookInfo);
	                	break;
	                case 8:
	                    running = false;
	                    System.out.println("Exiting the program...");
	                    break;
	                default:
	                    System.out.println("Invalid option, please try again.");
	                    break;
	            }
	        }
	    }

	    private static int getUserChoice(Scanner scanner) {
	        int choice = 0;
	        try {
	            choice = scanner.nextInt();
	            scanner.nextLine();
	        } catch (Exception e) {
	            scanner.nextLine();
	            System.out.println("Please enter a valid option.");
	        }
	        return choice;
	    }

	}


