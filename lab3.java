package lab4data;import java.util.Stack;


import java.util.Scanner;

public class lab3
{
    static class stack
    {
        int top=-1;
        String items[] = new String[100];

        void push(String x)
        {
            if (top == 99)
            {
                System.out.println("Stack full");
            }
            else
            {
                items[++top] = x;
            }
        }

        String pop()
        {
            if (top == -1)
            {
                System.out.println("Underflow error");
                return "\0";
            }
            else
            {
                String element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty()
        {
            return (top == -1) ? true : false;
        }
    }

    /* Returns true if character1 and character2 
       are matching left and right Parenthesis */
    static boolean isMatchingPair(Object object, String character2)
    {
        if (((String) object).compareTo("(") == 0 && character2.compareTo(")") == 0)
            return true;
        else if (((String) object).compareTo("{") == 0 && character2.compareTo("}") == 0)
            return true;
        else if (((String) object).compareTo("[") == 0 && character2.compareTo("]") == 0)
            return true;
        else
            return false;
    }

    /* Return true if expression has balanced  
       Parenthesis */
    static boolean areParenthesisBalanced(String exp[])
    {
        /* Declare an empty character stack */
        Stack st=new Stack();
       
       /* Traverse the given expression to  
          check matching parenthesis */
        for(int i=0;i<exp.length;i++)
        {
            
          /*If the exp[i] is a starting  
            parenthesis then push it*/
            if (exp[i].compareTo("{") == 0|| exp[i].compareTo("(") == 0 || exp[i].compareTo("[") == 0)
                st.push(exp[i]);
       
          /* If exp[i] is an ending parenthesis  
             then pop from stack and check if the  
             popped parenthesis is a matching pair*/
            if (exp[i].compareTo("}") == 0 || exp[i].compareTo(")") == 0 || exp[i].compareTo("]") == 0)
            {
                   
              /* If we see an ending parenthesis without  
                 a pair then return false*/
                if (st.isEmpty())
                {
                    return false;
                }
       
             /* Pop the top element from stack, if  
                it is not a pair parenthesis of character  
                then there is a mismatch. This happens for  
                expressions like {(}) */
                else if ( !isMatchingPair(st.pop(), exp[i]) )
                {
                    return false;
                }
            }

        }
          
       /* If there is something left in expression  
          then there is a starting parenthesis without  
          a closing parenthesis */

        if (st.isEmpty())
            return true; /*balanced*/
        else
        {   /*not balanced*/
            return false;
        }
    }

    /* UTILITY FUNCTIONS */
    /*driver program to test above functions*/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        String[] exp = new String[input.length()];
        for (int i=0;i<input.length();i++) {
        	exp[i] = String.valueOf(input.charAt(i));
        }
    	//String exp[] = {"(","(","(",")",")",")","(","(",")",")","(",")"};
       // String exp[] = {"(","(","(",")",")","(","(",")",")","(",")"};
        if (areParenthesisBalanced(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

} 