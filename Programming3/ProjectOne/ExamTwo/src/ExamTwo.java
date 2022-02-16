import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamTwo {

    String names[];
    int length;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		long sSortTotal = 0;
		long hSortTotal = 0;
		
		 ExamTwo sorter = new ExamTwo();
		 	// the strings need to be sorted are put inside this array
	        String names[] = nameArr(); 
	        //Clones of the original array are made
	        String[] qSort = names.clone();
	        String[] hSort = names.clone();        
	        
	        //finding the run time of the quick sort
	        long startTime = System.nanoTime();
	        sorter.sort(qSort);
	        sSortTotal += System.nanoTime() - startTime;
	        startTime = 0;
	        
	        //printing the original array
	        for (String i : names) {
		          System.out.print(i);
		          System.out.print(" ");
		        }
		        
		        System.out.println();
	        
		    //finding the run time of the heap sort and printing the sorted array
		    startTime = System.nanoTime();
	        MaxHeap test = hSort(hSort);
	        while(!test.isEmpty()) {
	        	
	        	System.out.print(test.remove());
	        	
	        }
	        hSortTotal += System.nanoTime() - startTime;
	        startTime = 0;
	        
	        System.out.println();
	        
	        
	        //printing the sorted array
	        for (String i : qSort) {
	          System.out.print(i);
	          System.out.print(" ");
	        }
	        
	        //printing the results
	        System.out.println();
	        System.out.println("Quick Sort Time: " + sSortTotal);
	        System.out.println("Max Heap Sort Time: " + hSortTotal);
	        
	    }
	
	//reading the csv file can adding all the elements to an array
	public static String[] nameArr() throws FileNotFoundException, IOException {
		
		List<String> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ianne\\eclipse-workspace\\ExamTwo\\src\\names.csv"))) {
		    String line;
		    try {
				while ((line = br.readLine()) != null) {
				    String[] values = line.split(",");
				    
				    String[] tempArr = new String[values.length];
				    
				    for (int i = 0; i < tempArr.length; i++) {
				    	
				    	if (i != 0 && values[i].length() > 0 && values[i] != null) {
				    		//tempArr[j++] = values[i];
				    		//System.out.println(values[i]);
				    		records.add(values[i]);
				    	}
				    	
				    }

				   
				    
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		String[] nameArr = new String[records.size()];
		for (int i = 0; i < records.size(); i++) {
			nameArr[i] = records.get(i);
		}
		
		return nameArr;
		
	}

		//quick sort
	    void sort(String array[]) {
	        if (array == null || array.length == 0) {
	            return;
	        }
	        this.names = array;
	        this.length = array.length;
	        quickSort(0, length - 1);
	    }
	    //quick sort helper
	    void quickSort(int lowerIndex, int higherIndex) {
	        int i = lowerIndex;
	        int j = higherIndex;
	        String pivot = this.names[lowerIndex + (higherIndex - lowerIndex) / 2];

	        while (i <= j) {
	            while (this.names[i].compareToIgnoreCase(pivot) < 0) {
	                i++;
	            }

	            while (this.names[j].compareToIgnoreCase(pivot) > 0) {
	                j--;
	            }

	            if (i <= j) {
	                exchangeNames(i, j);
	                i++;
	                j--;
	            }
	        }
	        //call quickSort recursively
	        if (lowerIndex < j) {
	            quickSort(lowerIndex, j);
	        }
	        if (i < higherIndex) {
	            quickSort(i, higherIndex);
	        }
	    }
	    //quick sort helper
	    void exchangeNames(int i, int j) {
	        String temp = this.names[i];
	        this.names[i] = this.names[j];
	        this.names[j] = temp;
	    }
		//method to add the string to a max heap
	    public static MaxHeap hSort(String[] names) {
	    	MaxHeap heap = new MaxHeap<String>();
	    	for(int i = 0; i < names.length; i++) {
	    		
	    		heap.insert(names[i]);
	    		
	    	}
	
	    	return heap;
	    }
	    
	}


