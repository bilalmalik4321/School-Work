package datastructs;

public class HeapInt {
		    
			private int [] heap ;
		    int n =0;
		    // Heap constructor
		    public HeapInt (int [] a){
		        n = a.length ;
		        for (int k = n/2; k >= 0; k--){
		            heapify(a ,n,k);
		        }
		        heap =a;
		    }
		    
		    public int removeMax () {
		        int max = heap[0];
		        //heap[0] = heap[n -1];
		        exch(heap, 1, n);
		        n--;
		        heapify(heap, n,max);
		        return max;
		    }
		     
		    void heapify(int arr[], int n, int i)
		    {
		         int largest = i; // Initialize largest as root
		         int l = 2*i + 1; // left = 2*i + 1
		         int r = 2*i + 2; // right = 2*i + 2

		         // If left child is larger than root
		         if (l < n && arr[l] > arr[largest]){
		             largest = l;
		         }


		         // If right child is larger than largest so far
		         if (r < n && arr[r] > arr[largest]){
		             largest = r;
		         }


		         // If largest is not root
		         if (largest != i)
		         {
		             int swap = arr[i];
		             arr[i] = arr[largest];
		             arr[largest] = swap;

		             // Recursively heapify the affected sub-tree
		             heapify(arr, n, largest);
		         }
		     }
		    private void exch(int[] pq, int i, int j) {
		        int swap = pq[i-1];
		        pq[i-1] = pq[j-1];
		        pq[j-1] = swap;
		    }

		    private static boolean less(int[] pq, int i, int j) {
		      if(pq[i-1] < pq[j-1]){
		            return true;
		        }else{
		            return false;
		      }
		    }
		}
