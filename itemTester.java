//	Bilal Malik 104435995	November 2, 2018	Assignment 2
package assignment2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class itemTester {

	static Scanner scanner = new Scanner(System.in);
    List<item> arr = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException {
        String find = "";
        int counter;
        boolean quit = false;
        //item a = new book("asdf", "adfs", 123, 234, 60.00);
        File f = new File("new.txt");
        List<item> arr = new ArrayList<item>();
        while(!quit){
            System.out.println("1. Add item");								//menu
            System.out.println("2. Display all items");
            System.out.println("3. Display by author name");
            System.out.println("4. Display by gift label");
            System.out.println("5. Delete item by id");
            System.out.println("6. Purchase item");
            System.out.println("7. Quit");
            System.out.println("Enter selection:");
            int input = scanner.nextInt();
            switch(input){

            case 1:									//if input is 1 to execute the following
                    System.out.println("Enter type of item(gift or book)");
                    String type = scanner.next();
                    if(type.equalsIgnoreCase("book")){
                        System.out.println("Enter the author's name:");
                        String name  = scanner.next();
                        System.out.println("Enter the title:");
                        String title = scanner.next();
                        System.out.println("Enter the year:");
                        int year = scanner.nextInt();
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        System.out.println("Enter price:");
                        double price = scanner.nextDouble();
                        item obj = new book(name, title, year, quantity, price);			//passes scanned values to gift constructor
                        obj.setQuantity(quantity);
                        arr.add(obj);
                        System.out.println("book:" + ((book) obj).getAuthor() + " added");
                        break;

                    };
                    if(type.equalsIgnoreCase("gift")) {
                        System.out.println("Enter the label:");
                        String label = scanner.next();
                        System.out.println("Enter the manufacturer:");
                        String manufac = scanner.next();

                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        item obj = new gift(label, manufac);
                        obj.setQuantity(quantity);
                        arr.add(obj);
                        System.out.println("gift: " + ((gift) obj).getLabel() + " added");		//casts object to type gift before calling get method function
                        break;
                    }else{
                        System.out.println("Invalid type");
                    }

                case 2:
                    if(arr.isEmpty()){
                        System.out.println("no items in inventory");
                        break;
                    }
                    for(item i: arr){						//walks through the for loop displaying all its contents

                        i.showInfo();
                    }
                    break;

                case 3:
                	List<String> bookList = new ArrayList<String>();

                    for(item i: arr){
                        if(i.type() == "book"){
                            bookList.add(i.Displayed());
                        }
                    }
                    Collections.sort(bookList);				//takes objects of type book and fills them in new list
                    for(String j:bookList) {				//then taking that list and sorting it and printing the contents
                    	System.out.println(j);
                    }
                    break;

                case 4:
                    List<String> labelList = new ArrayList<>();

                    for(item i: arr){
                        if(i.type() == "gift"){
                            labelList.add(i.Displayed());
                        }
                    }
                    Collections.sort(labelList);
                    for(String j:labelList) {
                    	System.out.println(j);
                    }
                    break;


        		case 5:
        			boolean found = false;
        			System.out.println("Enter the item id of item to be dealer");
        			int index = scanner.nextInt();
        			if(0<+ index && index < item.counter) {
        				for (item i : arr) {
        					if(i.getItem_id() == index) {
        						arr.remove(i);
        						found = true;
        						System.out.println("item "+i.Displayed() + " deleted");
        						break;
        					}
        				}
        				if(!found) {
        					System.out.println("Item not found");
        				}
        			}
        			break;

                case 6:
                    System.out.println("Enter the author's name/label name of the item");
                    String name = scanner.next();
                    for(item i:arr){
                        if(i.Displayed().equalsIgnoreCase(name)){
                            System.out.println("Enter quantity of items to be purchased");
                            int quantity = scanner.nextInt();
                            i.Purchased(quantity);
                            break;
                        }
                    }
                    break;

                case 7:
                    quit = true;
                    break;

            }

        }


    	//item obj = new book("a","b",1234,7,60.00);
    	String filename = ".scr";

    	try {
    	FileOutputStream fos = new FileOutputStream("C:/Users/bilal/Desktop/scr.txt");
    	ObjectOutputStream oos = new ObjectOutputStream(fos);

    	try {
    			oos.writeObject(arr);

    		oos.close();
    		fos.close();
    		System.out.println("Serialized data is saved in scr");

    	}catch(IOException i) {
    		i.printStackTrace();
    	}

    	System.out.println("Serialized data is saved in scr");

    	}catch(IOException i) {
		i.printStackTrace();
		}

		try {
    	FileInputStream fis = new FileInputStream("C:/Users/bilal/Desktop/scr.txt");
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	try {
    		ArrayList<item> srcList = new ArrayList<item>();
    		srcList = (ArrayList<item>) ois.readObject();
    		ois.close();
    		fis.close();
    		for(item n : srcList) {
    		if(n.getType() == "gift") {
    			System.out.println("Deserializing item...");
    			n.showInfo();
    		}
    		else {
    			System.out.println("Deserializing item...");
    			n.showInfo();
    		}

    	}

    	}catch(IOException i) {
			i.printStackTrace();
			return;
		}
		System.out.println(fis);
		System.out.println(ois.read());

		}catch(IOException i) {
			i.printStackTrace();
			return;
		}
	}
}
