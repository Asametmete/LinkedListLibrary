package Projectlibrary;



public class User {
	private Book head = null;
    private Book tail = null;
    
    
    
    String username;
    User next;
    
   
    public Book getHead() {
    	return head;
    }
    public void setHead(Book head) {
    	this.head = head;
    }
    
    public Book getTail() {
    	return tail;
    }
    public void setTail(Book tail) {
    	if(this.tail == null) {
    	this.tail = tail;
    	tail.next = null;
    	}
    	else {
    		this.tail.next = tail;
    		tail.next = null;
    		this.tail = tail;
    	}
    	
    }

    public User() {
        this.head = null;
        this.tail = null;
    }

	
	
}
