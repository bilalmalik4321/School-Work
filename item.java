package assignment2;
import java.util.ArrayList;
import java.util.List;

public abstract class item {
    static int item_id;
    protected double price;
    protected int quantity;
    static int counter = 0;
    
    /**
     * returns item_id
     * @return item_id
     */
    public int getItem_id() {
        return item_id;
    }
    
    /**
     * takes item_id and increment counter
     */
    public void setItem_id(int item_id) {
        this.item_id = counter;
        counter++;
    }
    
    /**
     * returns price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets passed value as price if it meet conditions
     * @param price
     */
    public void setPrice(double price) {
       if (quantity >= 0)
    	this.price = price;
    }

    /**
     * returns the quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * sets passed value as quantity if conditions are met
     * @param quantity
     */
    
    public void setQuantity(int quantity) {
       if (quantity >= 0)
    	this.quantity = quantity;
    }

    public abstract String getType();
    
    public abstract String Displayed();
    
    public abstract void Purchased(int quantity);
    
    public abstract String type();

    public abstract void showInfo();

}