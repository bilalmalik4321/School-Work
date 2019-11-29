public class Shoe extends Item {
	private double size;
	private String color;
	int c;
	
	public Shoe () {
	}
	
	public Shoe (double size, String color, double price, int quantity) {
		super (price, quantity);
		Title = "Shoe";
		c = ++id;
		this.size = size;
		this.color = color;
	}
	
	void setSize (double size) {
		this.size = size; 
	}
	
	void setColor (String color) {
		this.color = color;
	}
	
	double getSize () {
		return this.size;
	}
	
	String getColor () {
		return this.color;
	}
	
	public void Display () {
		System.out.println ("[" + c + "] " + Title + " - Color (" + color + ") Size (" + size + ") + Price (" + getPrice() + ") Quantity (" + getQuantity() + ")");
	}
	
	public void Purchase (int pur_quantity) {
        super.quantity = super.quantity - pur_quantity;
        System.out.println (super.quantity);
        System.out.println(pur_quantity+ " shoe(s) successfully purchased");
	}
}

