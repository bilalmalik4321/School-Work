public abstract class Item  {
	public static int id = 0;
	private double price;
	int quantity;
	protected String Title;
	int h;
	
	public Item () {
	}
	
	public Item (double price, int quantity) {
		setPrice (price);
		setQuantity (quantity);
	}
	
	void setPrice (double price) {
		if (price >= 0) {
			this.price = price;
		}
	}
	
	void setQuantity (int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		}
	}
	
	double getPrice () {
		return this.price;
	}
	
	int getQuantity () {
		return this.quantity;
	}
	
	public abstract void Display ();
	
	public abstract void Purchase (int quant);
}
