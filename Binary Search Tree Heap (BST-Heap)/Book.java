public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private String BookID;
    private int numOfCopies;
    
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_Light_Blue = "\u001B[94m";
    private final String ANSI_Light_Yellow = "\u001B[33m";
    private final String ANSI_Light_Mengta = "\u001B[95m";

    public Book(String title, String author, String BookID, int numOfCopies) {
        this.title = title;
        this.author = author;
        this.BookID = BookID;
        this.numOfCopies = numOfCopies;
    }
    
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setBookID(String BookID) {this.BookID = BookID;}
    public void setNumOfCopies(int numOfCopies) {this.numOfCopies = numOfCopies;}
    
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getBookID() {return BookID;}
    public int getNumOfCopies() {return numOfCopies;}
    
    public String toString() {
    	return "--> Book Title: "+this.getTitle()+", Author: "+this.getAuthor()+", ID: "+this.getBookID();
    }
    
    public void display() {
    	System.out.println("The current book record is as follows:");
    	System.out.println(this.ANSI_Light_Mengta+"Book Title: "+this.ANSI_Light_Blue+this.getTitle()+this.ANSI_RESET);
    	System.out.println(this.ANSI_Light_Mengta+"Book Author: "+this.ANSI_Light_Blue+this.getAuthor()+this.ANSI_RESET);
    	System.out.println(this.ANSI_Light_Mengta+"Book id: "+this.ANSI_Light_Blue+this.getBookID()+this.ANSI_RESET);
    	System.out.println(this.ANSI_Light_Mengta+"No. of Copies available: "+this.ANSI_Light_Blue+this.getNumOfCopies()+this.ANSI_RESET);
    }

    public static void main(String[] args) {
        MinHeap<Book> a = new MinHeap<>(10);
        MaxHeap<Book> b = new MaxHeap<>(10);
        Book book1 = new Book("HCI", "Arslan Tariq", "1", 0);
        Book book2 = new Book("DSA", "Kamal Ashraf", "2", 10);
        Book book3 = new Book("Linear Algebra", "Dr. Hassan Imran", "3", 10);
        Book book4 = new Book("Requirement Engineering", "Amir Saleem", "4", 10);

        a.insert(book4);
        a.insert(book1);
        a.insert(book3);
        a.insert(book2);

        b.insert(book4);
        b.insert(book1);
        b.insert(book3);
        b.insert(book2);

        a.breadthFirstTraversal();
        a.depthFirstTraversal();

        b.breadthFirstTraversal();
        b.depthFirstTraversal();

    }
    
    @Override
    public int compareTo(Book o){
        if(this.getBookID().compareTo(o.getBookID()) == 0){
            return 0;
        }else if (this.getBookID().compareTo(o.getBookID()) < 0) {
            return -1;
        }else {
            return 1;
        }
    }

}