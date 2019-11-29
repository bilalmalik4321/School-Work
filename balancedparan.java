package lab4data;

import java.util.Scanner;

public class balancedparan{
	
	static boolean isMatched ( String expression ) {
			final String opening = " ({[ ";
			final String closing = ")}]";
			Stack buffer = new Stack() ;
			for ( char c : expression.toCharArray() ) {
			if ( opening.indexOf(c) != -1) buffer.push(c);
			else if ( closing.indexOf(c) != -1) {
			if ( buffer.isEmpty() ) return false ;
			
			if ( closing.indexOf(c) != opening.indexOf( buffer.pop() ))
			return false ;
			}
		}
		return buffer.isEmpty() ;
		}
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String exp = new String();
		exp = scan.nextLine();
		scan.close();
		if(!isMatched(exp))
			System.out.println("Unbalanced");
		
		else
			System.out.println("Balanced");
		
		

			}
	}