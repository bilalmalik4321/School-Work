package assignment2;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class gift extends item implements Serializable{
    static Scanner scanner = new Scanner(System.in);
    private String label;
    private String manufacturer;

    /**
     * Overloaded constructor takes in two passed parameters to then be sat 
     * @param label
     * @param manufacturer
     */
    public gift(String label, String manufacturer) {
        this.label = label;
        this.manufacturer = manufacturer;
        counter++;
    }

    /**
     * over rides display in abstract class to return label as displayed
     */
    @Override
    public String Displayed() {
        	return label;
        
    }
    
    /**
     * over rides type to written pertaining type
     */
    @Override
    public String type(){
        return "gift";
    }

    /**
     * checks if the list is empty, then removing it and printing its contents
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

    public String getType() {
        return "gift";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Overrides print statement to display this
     */
    @Override
    public String toString() {
        return label+ "\t" + manufacturer;
    }

    /**
     * Over ride abstract class and prints contents of object with conjoining string
     */
    @Override
    public void showInfo(){

        System.out.println("Item Type:gift label:" +label + " manufacturer:" + manufacturer + " Item id: "+ item_id);
    }


}
    //make list:use arrays
    //complete is book
    //abstract item
    //cannot initiate abstract class
    //make reference = null to delete object