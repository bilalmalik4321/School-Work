package lab4data;

public class Stack2 {
	static int MAX;
    private int top=0;
    private char[] stacc;
    private static int counter;


    public Stack2(int MAX) {
    this.MAX=MAX;
    stacc= new char[MAX];
    }

    public void push(char a){
        if(!isFull()){
            stacc[++top] = a;
        }else{
            
        	return;
        }
    }

    public boolean isFull(){
        if(top==MAX){
            return true;
        }else{
            return false;
        }
    }

    public char pop(){

        if(!isEmpty()){
            char hold=stacc[top--];
            return hold;
        }else{
            
        	return '0';
        }
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        if(top==0){
            return true;
        }else{
            return false;
        }
    }
    public char top(){
        return stacc[top];
    }

    public void display(){

        for(int i=0;i<top;i++){
            System.out.print(stacc[i]);
        }
    }

    public boolean isBalance(String x){
        final String opening ="({[";
        final String closing =")}]";
        final String goodChars = "{}[]()0123456789+−-*∗/";
        int counter=0;
        char a;
        for (char c: x.toCharArray()) {
        if (goodChars.indexOf(c) == -1) {
        	System.out.println("This expression contains some invalid characters.");
        	System.exit(0);
        }
        //char[] g=x.toCharArray();
        
            
            if(opening.indexOf(c)!=-1){
                push(x.charAt(counter));
            }else if(closing.indexOf(c)!=-1){
                if(isEmpty()){
                    return false;
                }
                a=pop();
                //System.out.println(a);
                if(a=='0'){
                    break;
                }else {
                    if (closing.indexOf(c) != opening.indexOf(a)) {
                        //System.out.println(a);
                        //System.out.println("h");
                        return false;
                    }
                }
            }
            counter++;
        }
        return isEmpty();
    }
}
