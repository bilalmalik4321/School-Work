package Lab2data;

import java.io.File;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;

	public class lab2data {
	
		public class WordCountSort {

			public static void selectionSort(String[] data) {
				int n = data.length;									//2 ops
				for (int i = 0; i < n - 1; i++) {						//2n ops
					int minIndex = i;									//2 ops
					for (int j = i + 1; j < n; j++) {					//2n^2 ops
						if (data[minIndex].compareTo(data[j]) < 0) {	//2n ops
							minIndex = j;								// 0 to n
						}
					}
					if (i != minIndex)									//2n ops
						swap(data, minIndex, i);						// 0 to n
					
				}
			}

			public static void insertionSort(String[] data) {
				int n = data.length;									//2 ops
				for (int k = 1; k < n; k++) {							//2n ops
					String cur = data[k];								//2n ops
					int j = k;											//2n ops
					while (j > 0 && data[j - 1].compareTo(cur) > 0) {	//2n^2(m) ops
						data[j] = data[j - 1];							//2mn ops
						j--;											//2mn ops
					}
					data[j] = cur;										//2n ops
				}
			}

			/** Merge two strings. See the textbook for explanation. **/
			public static void merge(String[] S1, String[] S2, String[] S) {
				int i = 0, j = 0;																//2 ops
				while (i + j < S.length) {														//2n ops
					if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))		//2n ops
						S[i + j] = S1[i++];														//0 to n
					else																		//interchangeable
						S[i + j] = S2[j++];														//n to 0
				}
			}
			
			public static void mergeSort(String[] S) {
				int n = S.length;										//2 ops
				if (n < 2)												//0 to n
					return;												//1 op
				int mid = n / 2;										//2 ops
				// partition the string into two strings
				String[] S1 = Arrays.copyOfRange(S, 0, mid);			//2 ops
				String[] S2 = Arrays.copyOfRange(S, mid, n);			//2 ops
				mergeSort(S1);											//1 op
				mergeSort(S2);											//1 op
				merge(S1, S2, S);										//1 op
			}	

			private static void swap(String[] array, int i, int j) {
				String tmp = array[i];									//2 ops
				array[i] = array[j];									//2 ops
				array[j] = tmp;											//2 ops
			}	

			public static Entry<String, Integer> count_ARRAY_SORT(String[] tokens, String sortMethod) {
				int CAPACITY = 1000000;							//2 ops
				String[] words = new String[CAPACITY];			//2 ops
				int[] counts = new int[CAPACITY];				//2 ops
				if (sortMethod.equals("SELECT"))
					selectionSort(tokens);
				else if (sortMethod.equals("INSERT"))
					insertionSort(tokens);
				else if (sortMethod.equals("MERGE"))
					mergeSort(tokens);
				else if (sortMethod.equals("JAVA"))
					Arrays.sort(tokens);
				else if (sortMethod.equals("QUICK"))
					quickSortInPlace(tokens);
				else
					System.out.println(sortMethod + " sorting method does not exist.");

				int j = 0, k = 0;
				int len = tokens.length;
				while (j < len - 1) {
					int duplicates = 1;
					while (j < len - 2 & tokens[j].equals(tokens[j + 1])) {
						j++;
						duplicates++;
					}

					words[k] = tokens[j];
					counts[k] = duplicates;
					j++;
					k++;
				}

				/** get the max count **/
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

			static String[] readText(String PATH) throws Exception {
				Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
				// tokenize text. any characters other than English letters(a-z and A-Z
				// ) are delimiters.
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
				String PATH = "/Users/bilal/eclipse-workspace/254/src/lab1/NewTextDocument.txt";
				String[] METHODS = { "MERGE", "INSERT", "SELECT" };
				String[] DATASETS = { "200", "500", "1k", "5k", "10k", "100k", "1m", "" };

				String[] tokens;
				// run the experiments on different data sets
				for (int j = 0; j < 5; j++) {
					// run the experiments using different methods
					System.out.println("Data is " + DATASETS[j]);
					for (int i = 0; i < 3; i++) {
						tokens = readText(PATH + DATASETS[j] + ".txt");
						long startTime = System.currentTimeMillis();
						Entry<String, Integer> entry = count_ARRAY_SORT(tokens, METHODS[i]);
						long endTime = System.currentTimeMillis();
						String time = String.format("%12d", endTime - startTime);
						System.out.println(METHODS[i] + " method\t time=" + time + ". Most popular word is " + entry.getKey()
								+ ":" + entry.getValue());
					}
				}
			}
		}
	}
