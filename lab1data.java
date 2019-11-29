import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class lab1data {
	public static Entry<String, Integer> count_ARRAY(String[] tokens) {
		int CAPACITY = 10000;
		String[] words = new String[CAPACITY];
		int[] counts = new int[CAPACITY];
		for (int j = 0; j < tokens.length; j++) {
			String token = tokens[j];
			for (int i = 0; i < CAPACITY; i++) {
				if (words[i] == null) {
					words[i] = token;
					counts[i] = 1;
					break;
				} else if (words[i].equals(token))
					counts[i] = counts[i] + 1;
			}
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < CAPACITY & words[i] != null; i++) {
			if (counts[i] > maxCount) {
				maxWord = words[i];
				maxCount = counts[i];
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

	public static Entry<String, Integer> count_LINKED_LIST(String[] tokens) {
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();
		for (int j = 0; j < tokens.length; j++) {
			Iterator<Entry<String, Integer>> it=list.iterator();
			String word = tokens[j];
			boolean found = false;
			for (int i = 0; i < list.size(); i++) {
				Entry<String, Integer> e = it.next();
				if (word.equals(e.getKey())) {
					e.setValue(e.getValue() + 1);
					list.set(i, e);
					found = true;
					break;
				}
			}
			if (!found)
				list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			if (count > maxCount) {
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

	public static Entry<String, Integer> count_HASH(String[] tokens){
		tokens.length=tokens[length];
        String string2[]=tokens.split("[^a-zA-Z]"); 
        HashMap<String, Integer> uniques = new HashMap<String, Integer>();
        
        for (String word : string2){
            // ignore words 2 or less characters long
            if (word.length() <= 2) //to eliminate to, is, it etc
                {
                 continue;
                }
        Integer existingCount = uniques.get(word);
        uniques.put(word, (existingCount == null ? 1 : (existingCount + 1)));
            }
        
        Set<Map.Entry<String, Integer>> uniqueSet = uniques.entrySet();
        boolean first = true;
        for (Map.Entry<String, Integer> entry : uniqueSet)
            {
                        
                if (entry.getValue() > 1)
                    { 
                            System.out.println(entry.getKey()+" "+entry.getValue());
                    }
            }
    
    }
	
	static String[] readText(String PATH) throws Exception {
		Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		int length = 0;
		while (doc.hasNext()) {
			doc.next();
			length++;
		}

		String[] tokens = new String[length];
		Scanner s = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		length = 0;
		while (s.hasNext()) {
			tokens[length] = s.next().toLowerCase();
			length++;
		}
		doc.close();

		return tokens;
	} 
	
	

	public static void main(String[] args) throws Exception {

		String PATH = "/Users/bilal/eclipse-workspace/254/src/lab1/NewTextDocument2.txt";
		String[] tokens = readText(PATH);
		long startTime = System.currentTimeMillis();
		Entry<String, Integer> entry = count_LINKED_LIST(tokens);
		long endTime = System.currentTimeMillis();
		String time = String.format("%12d", endTime - startTime);
		System.out.println("time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

		tokens = readText(PATH);
		startTime = System.currentTimeMillis();
		entry = count_ARRAY(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());
		
		startTime = System.currentTimeMillis();
		entry = count_HASH(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());
		
	}

}