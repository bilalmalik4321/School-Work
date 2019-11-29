import java.util.Scanner;

public class Book extends Item{
	private String author, title;
	private int year;
	int c;
	
	public Book () {
		
	}

	public Book (String author, String title, int year, double price, int quantity) {
		super (price, quantity);
		Title = "Book";
		c = ++id;
		h=c;
		setAuthor (author);
		setTitle (title);
		setYear (year);
	}
	
	void setAuthor (String author) {
		this.author = author; 
	}
	
	void setTitle (String title) {
		this.title = title;
	}
	
	void setYear (int year) {
		this.year = year;
	}
	
	String getAuthor () {
		return this.author;
	}
	
	String getTitle () {
		return this.title;
	}
	
	int getYear () {
		return this.year;
	}
	
	public void Display () {
		System.out.println ("[" + c + "] " + Title + " - Title (" + title + ") Author (" + author + ") Published Year (" + year + ") + Price (" + getPrice() + ") + Quantity (" + getQuantity() + ")");
	}
	
	public void Purchase (int pur_quantity) {
        super.quantity = super.quantity - pur_quantity;
        System.out.println (super.quantity);
        System.out.println(pur_quantity+ " book(s) successfully purchased");
	}
}
