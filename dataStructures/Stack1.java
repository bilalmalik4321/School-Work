package lab4data;

public class Stack1 {
	public class stack
    {
        int top=-1;
        static final int size = 100;
        String items[] = new String[size];

        public void push(String x)
        {
            if (top == size-1)
            {
                String bigger[] = new String[size*2];
            	for(int i=0; i<size; i++) {
            		bigger[i] = items[i];
            	}
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
                int counter = 0;
                for (int i = 0; i < items.length; i ++)
                    if (items[i] != null)
                        counter ++;
                if(size/counter==4) {
                	String bigger[] = new String[size/2];
                	for(int i=0; i<size; i++) {
                		bigger[i] = items[i];
                	}
                	
                String element = items[top];
                top--;
                return element;
                
                
                }
            }
			return null;
        }

        boolean isEmpty()
        {
            return (top == -1) ? true : false;
        }
    
        String top() {
        	return items[top];
        }
    
    }

}
