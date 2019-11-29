import java.io.*;
import java.util.*;


public class main implements Comparator<person> {
    @Override
    public int compare(person o1, person o2) {
        if(o1.getLast_name().compareTo(o2.getLast_name()) == 0){
            System.out.println("passing");
            return o1.getFirst_name().compareTo(o2.getFirst_name());
        }
        return o1.getLast_name().compareTo(o2.getLast_name());



    }

    /**
     * compare each object against one another
     */
    static class NewComparator implements Comparator<person>{
        @Override
        public int compare(person o1, person o2) {
            if(o1.getLast_name().compareTo(o2.getLast_name()) == 0){
                return o1.getFirst_name().compareTo(o2.getFirst_name());
            }
            return o1.getLast_name().compareTo(o2.getLast_name());

        }
    }
    NewComparator comparator = new NewComparator();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        File file = new File("/Users/bilal/Desktop/file.txt");
        FileWriter fw = new FileWriter("/Users/bilal/Desktop/file.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String path = "";

        String first;
        String last;
        int day;
        int month;
        int year;

        for(int i = 0 ; i < 3; i++){
            int num=i+1;
            System.out.println("Enter the first name of the "+num+"th person");
            first = scanner.next();
            System.out.println("Enter the last name of the "+ num + "th person");
            last = scanner.next();
            System.out.println("Enter the day of birth");
            day = scanner.nextInt();
            System.out.println("Enter the month of birth");
            month = scanner.nextInt();
            System.out.println("Enter the year of birth");
            year = scanner.nextInt();
            person a = new person(first, last, day, month, year);
            try{
                bw.write(a.toString() +"\n");
            }catch(IOException ioe){
                ioe.printStackTrace();
            }

        }

        try{
            if(bw!= null){
                bw.close();
                }
        }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        String st;
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<person> arr2 = new ArrayList<person>();
        NewComparator comparator = new NewComparator();

        for(st = br.readLine(); st != null; st = br.readLine()){
            arr.add(st);
        }

        for(String i : arr){
            StringTokenizer st1 = new StringTokenizer(i);
            for(int j = 0 ;  st1.hasMoreTokens(); j++){
                st1.nextToken();
                st1.nextToken();
                String lastName = st1.nextToken();
                st1.nextToken();
                st1.nextToken();
                String firstName = st1.nextToken();
                st1.nextToken();
                st1.nextToken();
                String DOB = st1.nextToken();
                person a = new person(firstName, lastName, DOB);
                arr2.add(a);
            }
        }
        Collections.sort(arr2, comparator);
        for(person i : arr2) {
            System.out.println(i.toString());
        }
        person[] arr3 = new person[arr2.size()];
        for(int i = 0; i < arr2.size(); i++){
            arr3[i] = arr2.get(i);
        }
        boolean quit = false;
        int i = 0;
        while(!quit){
            System.out.println("Enter 0 to move forward");
            System.out.println("Enter 1 to move backwards");
            System.out.println("Enter 2 to change last name of current person");
            System.out.println("Enter 3 to change first name of current person");
            System.out.println("Enter 4 to change DOB of current person");
            System.out.println("Enter any other number to quit");
            int input = scanner.nextInt();
            System.out.println("current person first name:" + arr3[i].getFirst_name());
            switch(input){
                case 0:
                    i++;
                    System.out.println(arr3[i].toString());
                    break;
                case 1:
                    i--;
                    System.out.println(arr3[i].toString());
                    break;
                case 2:
                    System.out.println("Enter new last name:");
                    String newLast = scanner.next();
                    arr3[i].setLast_name(newLast);
                    System.out.println("new last name: " + arr3[i].getLast_name());
                    break;
                case 3:
                    System.out.println("Enter new first name:");
                    String newFirst = scanner.next();
                    arr3[i].setFirst_name(newFirst);
                    System.out.println("new last name: " + arr3[i].getFirst_name());
                    break;
                case 4:
                    System.out.println("Enter new dob name:");
                    String newDOB = scanner.next();
                    System.out.println("Enter DOB in dd/mm/yyyy format");
                    arr3[i].setDOB(newDOB);
                    break;
                default:
                    quit = true;
                    break;
            }
        }
        File file2 = new File("/Users/bilal/Desktop/file.txt");
        FileWriter fw2 = new FileWriter("/Users/bilal/Desktop/file.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        BufferedWriter bw2 = new BufferedWriter(fw2);
        for(int j = 0 ; j < arr3.length; j++){
            try{
                bw2.write(arr3[j].toString() +"\n");
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        try{
            if(bw2!= null){
                bw2.close();
            }
        }catch(Exception ex){
            System.out.println("Error in closing the BufferedWriter"+ex);
        }



        fw.close();

    }

}