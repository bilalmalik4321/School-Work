package Lab2data;

import java.util.Arrays;

public class lab2dat {
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
}
