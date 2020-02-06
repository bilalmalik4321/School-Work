import java.io.*;
import java.util.*;




public class A11 {


	public static void main(String[] args) throws Exception
	{
		BufferedReader br= null;
		BufferedWriter bw= null;

		String line;

		ArrayList<String> keyword = new ArrayList<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"));

		Set<String> Token = new HashSet<String>();


			 br = new BufferedReader(new FileReader(args[0]));
			 bw = new BufferedWriter(new FileWriter("A1.output"));

			 while((line = br.readLine()) != null)
			{
				 int i=0;
				  String t="";
				 while(i< line.length())
				 {


					 if(isLetterOrDigit(line.charAt(i)))
					 {

						 t +=line.charAt(i);

						 i++;

						 continue;
					 }
					 else
					 {
						 if(!(keyword.contains(t)))
						 {
							 Token.add(t);
						 }
						t="";

					 }

					 i++;

				 }
				 if(i >= line.length())
				 {
					 if(t.length()!= 0) {
						 if(!(keyword.contains(t)))
						 {
							 Token.add(t);
						 }
					 }
				 }

			}
			 Token.remove("");

			System.out.println(Token);
			br.close();
			bw.close();
		}


	private static boolean isLetterOrDigit(char c) {
	    return (c >= 'a' && c <= 'z') ||
	           (c >= 'A' && c <= 'Z') ||
	           (c >= '0' && c <= '9');
	}
}
