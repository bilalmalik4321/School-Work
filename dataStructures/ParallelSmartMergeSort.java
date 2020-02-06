package Lab2data;


import java.util.concurrent.RecursiveAction;

	public class ParallelSmartMergeSort{
	    private static final int MAX = 1 << 20;
	    private final String[] array;
	    private final String[] helper;
	    private final int low;
	    private final int high;

	    public ParallelSmartMergeSort(final String[] array, final int low, final int high) {
	        this.array = array;
	        helper = new String[array.length];
	        this.low = low;
	        this.high = high;
	    }

	    public  void compute() {
	        if (low < high) {
	            if (high - low <= MAX) {
	                mergesort(array, helper, low, high);
	            } else {
	                final int middle = (low + high) / 2;
	                final ParallelSmartMergeSort left = new ParallelSmartMergeSort(array, low, middle);
	                final ParallelSmartMergeSort right = new ParallelSmartMergeSort(array, middle + 1, high);
	                merge(array, helper, low, middle, high);
	            }
	        }
	    }
	    public static void merge(final String[] array, final String[] helper, final int low, final int middle, final int high) {
	        for (int i = low; i <= high; i++) {
	            helper[i] = array[i];
	        }

	        int helperLeft = low;
	        int helperRight = middle + 1;
	        int current = low;

	        while (helperLeft <= middle && helperRight <= high) {
	            if (helper[helperLeft].compareTo(helper[helperRight]) >= 0) {
	                array[current] = helper[helperLeft++];
	            } else {
	                array[current] = helper[helperRight++];
	            }
	            current++;
	        }

	        while (helperLeft <= middle) {
	            array[current++] = helper[helperLeft++];
	        }
	    }
	    public static void mergesort(final String[] array, final String[] helper, final int low, final int high) {
	        if (low < high) {
	            final int middle = (low + high) / 2;
	            mergesort(array, helper, low, middle);
	            mergesort(array, helper, middle + 1, high);
	            merge(array, helper, low, middle, high);
	        }
	    }
	}

