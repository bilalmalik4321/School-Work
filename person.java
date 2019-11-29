import java.util.Comparator;

public class person implements Comparator<String> {
    private String first_name;
    private String last_name;
    private String DOB;

    public person(String first_name, String last_name, int day, int month, int year){
        this.first_name = first_name;
        this.last_name = last_name;
        DOB = day + "/"+ month + "/" + year;
    }
    public person(String first_name, String last_name, String DOB){
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public String toString(){
        return  "Last name "+ last_name +" First name: "+first_name+" , DOB: "+DOB;
    }
    public int compare(String o1, String o2){
        int lastName1 = o1.indexOf("last name:");
        int lastName2 = o2.indexOf("last name");
        lastName1 += 10;
        lastName2 += 10;

        return o1.compareToIgnoreCase(o2);
    }

}
