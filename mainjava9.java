import java.io.*;
import java.util.*;

public class mainjava9 {

    public static void main (String args[]) throws IOException{
        Scanner scan = new Scanner(System.in);
        File file = new File("/Users/bilal/Desktop/file.txt");
        FileWriter fw = new FileWriter("/Users/bilal/Desktop/file.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] lnList = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("What is the given first name?");
            String fn = scan.next();
            System.out.println("What is the given surname?");
            String ln = scan.next();
            System.out.println("What is the given month of the date of birth?");
            int month = scan.nextInt();
            System.out.println("What is the given day of the date of birth?");
            int day = scan.nextInt();
            System.out.println("What is the given year of the date of birth?");
            int year = scan.nextInt();

            ArrayList<record> arr = new ArrayList<>();

            record a = new record(ln, fn, month, day, year);
            arr.add(a);


            try {
                bw.write(a.toString() + "\n");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }

        try {
            if (bw != null) {
                bw.close();
            }
        } catch (IOException ex) {
            System.out.println("Error closing the Buffer reader");
        }

        while(){

        }

        record[] arr = new record[arr2.size()];
        for(int k=0;k< arr.length();k++){
            arr[k] = arr.get(k);
        }

    }
}
