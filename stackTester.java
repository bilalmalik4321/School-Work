package lab4data;
import java.util.Scanner;


public class stackTester {
	public static void main(String[] args) {

        Stack2 a;
        String b;
        Scanner sc = new Scanner(System.in);
        //Character[] d;
        
        b=sc.nextLine();
        
        a=new Stack2(b.length());

        boolean e=true;


            e = a.isBalance(b);

            if(e){
                System.out.print("is balanced");
            }else{
                System.out.print("not balanced");
            }
        }


}
