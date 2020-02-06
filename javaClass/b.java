package assignment2;

public class b extends a{
	private int a = 1;
	public b() {
		a++;
		super.a=this.a;
	}
	public b(int b) {
		super(b);
		this.a=b++;
	}
	public String toString() {
		return "a="+a;
	}

}
