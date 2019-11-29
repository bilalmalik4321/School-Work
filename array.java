package lab4data;

import java.util.Scanner;

public class array 
{ 
    public static void main(String[] args) 
    { 
        char task1 [] = {'h','a','b','s','!'};
        Stack c = new Stack();
        for(int i=0; i<5;i++) {
        	if(c.isEmpty()== true)
        	c.push(task1 [i]);
        }
        for(int k=0; k<6;k++) {
        	if(c.isEmpty()==false) {
        		System.out.println(c.pop());
        		
        }
    	Scanner input = new Scanner(System.in);
    	String string = input.nextLine();
        char braces[] = { '[' ,  '{' , '(' }; 
        char braces2[] = { ']' , '}' , ')' };
        input.close();
        Stack s = new Stack();
        for(int i = 0; i<string.length(); i++) {
        	for(int j = 0; j<3;j++) {
        		if(string.charAt(i)==braces[j]) {
        			s.push(string.charAt(i));
        		}
        	}
        }
        
        
        //s.push(10); 
        //s.push(20); 
        //s.push(30); 
        System.out.println(s.pop() + " Popped from stack"); 
        }
    }
}

