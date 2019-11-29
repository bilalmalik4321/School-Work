package lab4data;

public class task1 {
	public static void main(String[] args) {
		char[] str = {'1','i','c','2','!'};
		Stack st = new Stack();
		for (int i=0;i<5;i++) {
			st.push(str[i]);
		}
		
		System.out.println();
		System.out.println(st.size());
		System.out.println(st.peek());
		System.out.println(st.isEmpty());
		System.out.println();
		
		for (int j=0;j<5;j++) {
			System.out.println(st.pop());
		}
		System.out.println(st.isEmpty());
	}
}