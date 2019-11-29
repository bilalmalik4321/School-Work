
public class record {
	private String firstName;
	private String lastName;
	
	private int month;
	private int date;
	private int year;
	private String dateOfBirth;
	 
	public record(String lastName,String firstName,int month, int day,int year) {
		setBDay(month,day,year);
		setFirst(firstName);
		setLast(lastName);
	}
	
	void setBDay(int month, int day,int year){

		this.dateOfBirth=month+"/"+day+"/"+year;
	}
	
	String getBDay(){

		return dateOfBirth;
	}
	
	void setFirst(String firstName){
		this.firstName=firstName;
	}
	
	String getFirst(){
		return firstName;
	}
	
	void setLast(String lastName){
		this.lastName=lastName;
	}
	
	String getLast(){
		return lastName;
	}

	public String toString(){
		return lastName+", "+firstName+", "+dateOfBirth;
	}
}
