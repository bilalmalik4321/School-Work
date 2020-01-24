import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.*;

public class A12 {

	static int idc=0;

	public static void main(String args[]) throws Exception {

		List<String> arr=new ArrayList<String>();
		String check[]=new String[]{"INT","MAIN","BEGIN","STRING","REAL","WRITE","READ","IF","ELSE","RETURN","END"};
		for(String l: check) {
			arr.add(l);
		}

		Pattern p = Pattern.compile("(?:\"[^\"]*\")|[\\w^\\d][\\w]*");

		String line;


			File fd1=new File(args[0]);

			BufferedReader br=new BufferedReader(new FileReader(fd1));


			String st;

			Matcher m;


			while((line=br.readLine())!=null) {

				st=new String(line);


				m=p.matcher(st);


				while(m.find()) {
					String str=m.group();
					if(Character.isLetter(str.charAt(0))&&!arr.contains(m.group())) {
								idc++;
								arr.add(m.group());
					}
				}
			}

			br.close();
			File fd=new File("A1.output");

		if(!fd.exists()) {

				fd.createNewFile();}

		PrintWriter pw=new PrintWriter(fd);
		pw.println("identifiers:"+idc);

		pw.close();

	}

}
