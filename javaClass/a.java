package assignment2;

public class a {
	protected int a = 0;
	public a(int a) {
		this.a = ++a;
	}
	public a() {
		a=1;
	}
	protected int b(int a) {
		int b=a;
		this.a+=b+a;
		return ++this.a;
	}
	
}
