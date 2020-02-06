package lab4data;


/* Java program to implement basic stack 
operations */
public class Stack 
{ 
    static final int MAX = 1000; 
    int top; 
    char[] a = new char[MAX]; // Maximum size of Stack 
  
    boolean isEmpty() 
    { 
        return (top < 0); 
    } 
    
    Stack() 
    { 
        top = -1;
    } 
  
    void push(char c) 
    { 
        if (top >= (MAX-1)) 
        { 
            System.out.println("Stack Overflow"); 
        } 
        else
        { 
            a[++top] = c; 
            System.out.println(c + " pushed into stack"); 
        } 
    } 
  
    char pop() 
    { 
        if (top < 0) 
        { 
            System.out.println("Stack Underflow"); 
            return '0'; 
        } 
        else
        { 
            char x = a[top--]; 
            return x; 
        } 
    }
    
    char peek(){
    	return a[top];
    }
    
    int size() {
    	return top+1;
    }
	
} 
  
