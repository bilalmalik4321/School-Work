package assignment2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class book extends item implements Serializable{
    static Scanner scanner = new Scanner(System.in);
    private String author;
    private String title;
    private int year;

    /**
     * 
     * @param author
     * @param title
     * @param year
     * @param quantity
     * @param price
     */
    public book(String author, String title, int year, int quantity, double price) {
    	this.price = price;
    	this.author = author;
        this.title = title;
        this.year = year;
        counter++;
    }

    /**
     * over rides display in abstract class to return author as displayed
     */
    @Override
    public String Displayed() {
        return author;
    }

    /**
     * overrides type to written pertaining type
     */
    @Override
    public String type(){
        return "book";
    }

    /**
     * checks if inventory is not yet, if this is the case to then remove an item from the inventory
     */
    @Override
    public void Purchased(int quantity) {
        if((getQuantity() - quantity) >= 0){
            this.quantity -= quantity;
            System.out.println("purchased " + quantity);
            System.out.println(this.quantity + " left");

        }else{
            System.out.println("Not enough items in the inventory");

        }
    }
    
    /**
     * Overrides method to return string of data type 
     */
    @Override
    public String getType() {
    	return "book";
    }
    

    /**
     * Over ride method to display this when object is printed
     */
    @Override
    public String toString() {
        return author + "\t" + title + "\t" + year;
    }

    /**
     * method if called displays the entirety of the object with conjointing string 
     */
    @Override
    public void showInfo() {
        System.out.println("Item Type:book, author:"+author + ", title:" + title + ", year:" + year + ",Item id: "+ item_id);
    }

    /**
     * proceeding are getters and setters 
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public double getPrice() {
    	return price;
    }

    /**
     * set price if condition of being greater or equal to zero is true
     */
    public void setPrice(double price) {
       if(price>=0)
        this.price = price;
    }
}

