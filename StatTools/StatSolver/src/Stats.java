

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stats {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		int numClasses = 0;
		int counterone = 0;
		double test = 0;
		double max = 0;
		double min = 0;
		double snum = 1000;
		double lower = 0;
		int classnum = 0;
		List<Double> l1 = new ArrayList<Double>();
		File data = new File("src\\numbers.txt");
		Scanner sc = new Scanner(data);

		

		
		

		
		while (sc.hasNext()) {
			
			double num = sc.nextDouble();
			l1.add(num);

			
			if(num > max) {
				
				max = num;
				
			}
			
			if(num < min) {
				
				min = num;
				
			}
	
		}
		
		while (snum <= 5000) {

			for(int i = 0; i < l1.size(); i++) {
				
				double num = l1.get(i);
				
				if (num < snum && num >= lower) {
					
					counterone++;
					//showing all the data
					//System.out.println(num);
					
				}

			}
			test = (double)counterone / l1.size();
			
			//simple graph
			System.out.print("Case Number: " + classnum + " ");
			for (int i = 0; i < counterone; i++) {
				
				System.out.print("*");
				
			}
			System.out.println();
			//detailed information
			System.out.println("Numbers between " + lower + " and " + snum+ " : " + counterone + ": Have a rel Freq of : " + String.format("%,.4f", test) + " Which is " + String.format("%,.3f", test * 100) + " percent");
			snum += 1000;
			lower += 1000;
			classnum++;
			test = 0;
			counterone = 0;
			
		}
		

		
		System.out.println(max);
		System.out.println(min);
		System.out.println(l1.size());

		
		
	}
	
}



