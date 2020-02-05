import java.util.*;

public class Assign2 {
	public static void main(String[] args) {
		Item itemList[] = new Item[100];
		
		Scanner sc = new Scanner(System.in);
		String Title, title, author, label, manufacturer, color;
		int choice = 0, counter = 0, year, quantity, bCount = 0, gCount = 0, sCount = 0, id1 = 0;
		double size, price;
		
		Book sortBooks[] = new Book [itemList.length];
		GiftCard sortCards[] = new GiftCard [itemList.length];
		Shoe sortShoes[] = new Shoe [itemList.length];

		while (choice != 7) {
			System.out.println ("---------------------------------------");
			System.out.println ("Menu:\n1. Add an item\n2. Display all items\n3. Display books sorted by author name\n4. Display gifts sorted by label\n5. Display shoes sorted by size\n6. Delete an item\n7. Purchase an item\n8. Exit");
			System.out.println ("---------------------------------------");
			System.out.print ("Enter a number: ");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					System.out.println ("\nWhat item would you like to add?\n1. Book\n2. Gift card\n3. Shoe\n");
					System.out.print ("Enter your choice in words (exactly as above): ");
					Title = new Scanner (System.in).nextLine();
					if (Title.equals("Book")) {
						System.out.print ("\nAuthor name: ");
						author = new Scanner (System.in).nextLine();
						System.out.print ("Book name: ");
						title = new Scanner (System.in).nextLine();
						System.out.print ("Year published: ");
						year = sc.nextInt();
						System.out.print ("Price: ");
						price = sc.nextDouble();
						System.out.print ("Quantity: ");		
						quantity = sc.nextInt();
						sortBooks[bCount] = new Book ();
						sortBooks[bCount].setAuthor (author);
						sortBooks[bCount].setTitle ("Book");
						sortBooks[bCount].setYear (year);
						sortBooks[bCount].setPrice (price);
						sortBooks[bCount].setQuantity (quantity);
						sortBooks[bCount++].c = ++id1;
						itemList[counter++] = new Book(author, title, year, price, quantity);
					}
					else if (Title.equals("Gift card")) {
						System.out.print ("\nLabel name: ");
						label = new Scanner (System.in).nextLine();
						System.out.print ("Manufacturer: ");
						manufacturer = new Scanner (System.in).nextLine();
						System.out.print ("Price: ");
						price = sc.nextDouble();
						System.out.print ("Quantity: ");		
						quantity = sc.nextInt();
						sortCards[gCount] = new GiftCard ();
						sortCards[gCount].setLabel (label);
						sortCards[gCount].setManufacturer(manufacturer);
						sortCards[gCount].setPrice(price);
						sortCards[gCount].setQuantity(quantity);
						sortCards[gCount++].c = ++id1;
						itemList[counter++] = new GiftCard (label, manufacturer, price, quantity);
					}
					else if (Title.equals("Shoe")) { 
						System.out.print ("\nSize: ");
						size = new Scanner (System.in).nextDouble();
						System.out.print ("Color: ");
						color = new Scanner (System.in).nextLine();
						System.out.print ("Price: ");
						price = sc.nextDouble();
						System.out.print ("Quantity: ");		
						quantity = sc.nextInt();
						sortShoes[sCount] = new Shoe ();
						sortShoes[sCount].setSize(size);
						sortShoes[sCount].setColor(color);
						sortShoes[sCount].setPrice(price);
						sortShoes[sCount].setQuantity(quantity);
						sortShoes[sCount++].c = ++id1;
						itemList[counter++] = new Shoe(size, color, price, quantity);
					}
					break;
				case 2:
					for (int i = 0; i < counter; i++) { 
						itemList[i].Display();
					}
					break;
				case 3:
					Book temp = new Book();
					
					for (int i = 0; i < bCount; i++) {
						for (int j = i + 1; j < bCount; j++) {
							if (sortBooks[i].getAuthor().compareTo(sortBooks[j].getAuthor()) > 0) {
								temp = sortBooks[i];
								sortBooks[i] = sortBooks[j];
								sortBooks[j] = temp;
							}
						}
					}
					
					for (int r = 0; r < bCount; r++) {
						sortBooks[r].Display();
					}
					break;
				case 4:
					GiftCard temp1 = new GiftCard();
					
					for (int i = 0; i < gCount; i++) {
						for (int j = i + 1; j < gCount; j++) {
							if (sortCards[i].getLabel().compareTo(sortCards[j].getLabel()) > 0) {
								temp1 = sortCards[i];
								sortCards[i] = sortCards[j];
								sortCards[j] = temp1;
							}
						}
					}
					
					for (int r = 0; r < gCount; r++) {
						sortCards[r].Display();
					}
					break;
				case 5:
					Shoe temp2 = new Shoe();
					
					for (int i = 0; i < sCount; i++) {
						for (int j = i + 1; j < sCount; j++) {
							if (sortShoes[i].getSize() > sortShoes[j].getSize()) {
								temp2 = sortShoes[i];
								sortShoes[i] = sortShoes[j];
								sortShoes[j] = temp2;
							}
						}
					}
					
					for (int r = 0; r < sCount; r++) {
						sortShoes[r].Display();
					}
					break;
				case 6:
					int delete;
					for (int i = 0; i < counter; i++) {
						itemList[i].Display();
					}
					System.out.print ("\nWhich item would you like to delete? ");
					delete = sc.nextInt();
					int search=0;
					for(search=0;search<counter;search++) {
						if(itemList[search].h==delete) {
							break;
						}
					}
					int i,c, store = 0;
					
					if (itemList[search].Title.equals("Book")) {
						for (int r = 0; r < bCount; r++) {
							if (sortBooks[r].c == delete) {
								store = r;
								break;
							}
						}
					for ( c = store; c < bCount - 1; c++) {
						sortBooks[c] = sortBooks [c + 1];
					}
					sortBooks[c]=null;
					bCount--;
					}
					
					for (i = search; i < counter - 1; i++) {
						itemList[i] = itemList[i + 1];
					}
					itemList [i] = null;
					counter--;
					
					for (int k = 0; k < counter; k++) {
						itemList[k].Display();
					}
					
					
					break;
				case 7:
					int t, purchase;
					for (t = 0; t < counter; t++) {
						itemList[t].Display();
					}
					System.out.print ("What item would you like to purchase: ");
					purchase = sc.nextInt(); 
					search = 0;
	
					for(search=0;search<counter;search++) {
						if(itemList[search].h==purchase)
						{
							break;
						}
					}
					
					int pur_quantity = 0;
					
					if (itemList[search].Title.equals("Book")) {
						for (t = 0; t < bCount; t++) {
							if (sortBooks[t].c == purchase) {
						        System.out.println("\nHow many book(s) would you like to purchase");
						        pur_quantity = sc.nextInt();
								sortBooks[t].Purchase(pur_quantity);
							}
						}
						
						for (t = 0; t < counter; t++) {
							if (itemList[t].id == purchase) {
								itemList[t].quantity -= pur_quantity;
							}
						}
					}
					else if (itemList[purchase].Title.equals("Gift card")) {
						
					}
					else if (itemList[purchase].Title.equals("Shoe")) {
						
					}
					
					for (t = 0; t < counter; t++) {
						itemList[t].Display();
					}
					
					break;
				default: 
					if (choice == 7) {
						System.out.println ("Bye!");
						break;
					}
					else {
						System.out.println ("Invalid option. Try again!");
						break;
					}
			}
		}
	}
}
