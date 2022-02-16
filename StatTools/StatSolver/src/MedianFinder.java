import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianFinder {

	public static void main(String[] args) throws FileNotFoundException {

		File data = new File("src\\numbers.txt");
		Scanner sc = new Scanner(data);
		List<Double> outlier = new ArrayList<Double>();
		List<Double> l1 = new ArrayList<Double>();
		List<Double> l2 = new ArrayList<Double>();
		List<Double> l3 = new ArrayList<Double>();
		List<Double> l4 = new ArrayList<Double>();
		double median = 0;
		double firstQ = 0;
		double thridQ = 0;
		
		
		while (sc.hasNext()) {
			
			double num = sc.nextDouble();
			l1.add(num);

		}
		
		double[] temp = new double[l1.size()];
		
		for(int i= 0; i < l1.size(); i++) {
			
			temp[i] = l1.get(i);
			//System.out.println(i + " " + l1.get(i));
			
		}
		
		bubbleSort(temp);
		
	
		
		for(int i = 0; i < l1.size(); i++) {
			
			l2.add(temp[i]);
			System.out.println(i + " " + temp[i]);
		}
		
		//System.out.println(l2.size());
		
		median = medianFinder(l2);
		
		System.out.println("Q2: " + median + " is at " + l2.size()/2);
		
		for(int i = 0; i < l2.size()/2; i++) {
			
			l3.add(l2.get(i));
			
		}
		
		firstQ = medianFinder(l3);
		
		System.out.println("Q1: " + firstQ + " is at " + l2.size()/4);
		
		for(int i = l2.size()/2; i < l2.size(); i++ ) {
			
			l4.add(l2.get(i));
			
		}
		
		thridQ = medianFinder(l4);
		
		System.out.println("Q3: " + thridQ + " is at " + (l2.size() - (l2.size()/4)));
		
		System.out.println("Outliers:");
		outlierFinder(l2, firstQ, thridQ);
		
		
	}
	


	     static void bubbleSort(double arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (arr[j] > arr[j+1])
	                {
	                    // swap arr[j+1] and arr[j]
	                    double temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	    }
	     
	     static double medianFinder(List<Double> temp) {
	    	 double median = 0;
	    	 
	 		if(temp.size() % 2 != 0) {
				
				median = temp.get(temp.size()/2);

				
				
				
				
			} else if(temp.size() % 2 == 0) {
				
				int middle = temp.size() / 2;
				int middletwo = middle - 1;
				median = (temp.get(middle) + temp.get(middletwo)) / 2;
				
				
				
			}
	    	 
	    	 
			return median;
	     }
	  

	  static void outlierFinder(List<Double> temp, double lower, double upper) {
		  double IQR = upper - lower;
		  double lFence = lower - (1.5*IQR);
		  double hFence = upper + (1.5*IQR);
		  
		  //System.out.println(IQR);
		  //System.out.println(lFence);
		  //System.out.println(hFence);
		  
		  for(int i = 0; i < temp.size(); i++) {
			  double num = temp.get(i);
			  
			  if(temp.get(i) < lFence) {
				  
				  System.out.println("Lower: " + temp.get(i));
				  
			  }else if(temp.get(i) > hFence) {
				  
				  System.out.println("Higher: " + temp.get(i));
				  
			  }
			  
		  }
		  
	  }


	}

