package Projectlibrary;



public class Adminpanel {
	
	Book head = null;    // All of the our books will be in this list
	Book tail = null;
	
	User userhead = null;  // All of the our user will be in this list
    User usertail = null;
    
    
	
    
	
	public void insertbook(String _Name, String _Author , String _Genre  ) { // We will insert newbook to our List
		
		
		
		
		Book newbook = new Book();	
		newbook.name = _Name;
		newbook.author = _Author;
		newbook.genre = _Genre;
		newbook.Isavailable = true;
	
		if(head == null) {
			head = newbook;
			tail = newbook;
			
			System.out.println("First book added! ->" + newbook.name);
			
		}
		else {
			tail.next = newbook;
			newbook.next = null;
			tail = newbook;
			
			System.out.println("New book added ->" + newbook.name);
			
		}
		newbook.count++;
	    
		
	 
	
	}
	
	public void remove(String bookname ) {   							// We will remove a book to our List
		
			if(head == null) {
				System.out.println("There are no books to remove in this library");
			}
		
			else if(head.next == null && head.name.equals(bookname)) {                    // We examine each situation in this part
				head = null;
				tail = null;
			
				System.out.println("The Last book removed from the library");
			}
			else {
				Book temp = head;
				Book temp2 = head;
				while( !temp.name.equals(bookname) && temp != null) {
					temp2 = temp;
					temp = temp.next;
				}
				if(temp == null) {
					System.out.println("book not found");
				}
			
				else {
					temp2.next = temp.next;
					temp.count--;
					temp = null;
				
				
				System.out.print("Book removed successfully!");
			}
		}
	}
	
	public void infobook(String bookname) {
		Book book = head;
	
		
		while (book != null && !book.name.equals(bookname) ) {
			book = book.next;
		}
		
		System.out.println("Book Title: "+book.name);
		System.out.println("Author: "+book.author);
		System.out.println("Genre: "+book.genre);
		
	}
	
	public void insertuserbook(String username,  String name) {
		User user = sourceuser(username);
		Book book = sourcebook(name);
		
		if(book.name == "not found" || user.username.equals("not found")) {
			System.out.println("The book or The user was not found!");
		}
		else {
			if(user.getHead() == null ) {
				if(book.Isavailable == true) {
				IsavailableNo(name);
				user.setHead(book);
				user.setTail(book);
				
				
				System.out.println(book.name +"/"+ book.author+" added to "+user.username+"'s list");
				}
				else {
					System.out.println("The book is not available");
				}
			
				
			}
			else {
				
				if(book.Isavailable == true) {
					IsavailableNo(name);
					user.setTail(book);
					
					
					
					System.out.println(book.name +"/"+ book.author+" added to "+user.username+"'s list");
					
				}
				else {
					System.out.println("The book is not available");
				}
			
				
			}
		}
	}
	
	public void removeuserbook(String username,  String name) {                                           
		User user = sourceuser(username);
		Book book = sourcebook(name);
		
		if(book.name == "not found" || user.username.equals("not found")) {
			System.out.println("The book or The user was not found!");
		}
		
		else {
			if(user.getHead() == null ) {
				System.out.println("There is no book to delete");
			}
			else if (user.getHead().name.equals(name)) {
				user.setHead(user.getHead().next); 
			}
			else if(user.getHead().next == null &&  user.getHead().name.equals(name) ) {
				user.setHead(null);
				user.setTail(null);
				IsavailableYes(name);
			
				System.out.println("The Last book removed from the library");
			}
			else {
				Book temp = user.getHead();
				Book temp2 =user.getHead();;
				while( !temp.name.equals(name) && temp != null) {
					temp2 = temp;
					temp = temp.next;
				}
				if(temp == null) {
					System.out.println("book not found");
				}
			
				else {
					temp2.next = temp.next;
					temp.count--;
					temp = null;
				
				
				System.out.print("Book removed successfully!");
			}
		}
		}
		
		
		
	}
	
	public void IsavailableNo(String bookname) {                  
		Book book = head;
	
		
		
		while (book != null && !book.name.equals(bookname) ) {
			book = book.next;
		}
		
		book.Isavailable = false;
		
		
	}
	
	public void IsavailableYes(String bookname) {                  
		Book book = head;
	
		
		
		while (book != null && !book.name.equals(bookname) ) {
			book = book.next;
		}
		
		book.Isavailable = true;
		
		
	}
	
	public void Signup(String username) { 
		User temp = new User();
		
		
		
		temp.username = username;

		if(userhead == null) {
			userhead = temp;
			usertail = temp;
			System.out.println("Welcome " +username+", Your Account added our system!");
		}
		else {
			usertail.next = temp;
			temp.next = null;
			usertail = temp;
			System.out.println("Welcome " +username+", Your Account added our system!");
			
		}

}
	public User sourceuser(String username) {
		User temp = userhead;
		User answer = new User();
		
		
		while(temp != null && !temp.username.equals(username)) {
		   
			temp = temp.next;
			
		}
		
		if(temp == null) {
			answer.username = "not found";
		return answer;}
		
		else {
			
		return temp;}
		
		
	}
	
	public Book sourcebook(String name) {
		Book temp = head;
		Book temp2 = new Book();
		Book answer = new Book();
		
		while(temp != null && !temp.name.equals(name)) {
		        temp = temp.next;
		    }
		
		if(temp == null) {
			answer.name ="not found";
		return answer;}
		
		else {
			temp2.name = temp.name;
			temp2.author = temp.author;
			temp2.genre = temp.genre;
			temp2.Isavailable = temp.Isavailable;
		return temp2;
		}
	}
	
	
	
	public void print() {    
		Book temp = head;
		
		while(temp != null) {
			System.out.println(" - " + temp.name+" / "+temp.author +" - ");
			temp = temp.next;
			
		}
		
	
	
}
	
	public void printuser() {     
		Book temp = head;
		
		while(temp != null) {
			System.out.println(" - " + temp.name+" / "+temp.author +" - ");
			temp = temp.next;
			
		}
		
	
	
}
	
	
	
	public void printlist(String username) {     
		if(sourceuser(username).username == "not found") {
			System.out.println("The User was not found!");
		}
		else {
			Book temp = sourceuser(username).getHead();
		
		while(temp != null) {
			System.out.println(" - " + temp.name+" / "+temp.author +" - ");
			temp = temp.next;
			
		}
		}
		
}
}
	
