public class GiftCard extends Item {
	private String label, manufacturer;
	int c;
	
	public GiftCard () {
	}
	
	public GiftCard (String label, String manufacturer, double price, int quantity) {
		super (price, quantity);
		Title = "Gift card";
		c = ++id;
		setLabel (label);
		setManufacturer (manufacturer);
	}
	
	void setLabel (String label) {
		this.label = label;
	}
	
	void setManufacturer (String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	String getLabel () {
		return this.label;
	}
	
	String getManufacturer () {
		return this.manufacturer;
	}
	
	public void Display () {
		System.out.println ("[" + c + "] " + Title + " - Label (" + label + ") Manufacturer (" + manufacturer + ") Price (" + getPrice() + ") + Quantity (" + getQuantity() + ")");
	}
	
	public void Purchase (int pur_quantity) {
        super.quantity = super.quantity - pur_quantity;
        System.out.println (super.quantity);
        System.out.println(pur_quantity+ " gift card(s) successfully purchased");
	}
}
