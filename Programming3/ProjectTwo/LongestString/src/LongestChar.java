import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LongestChar {

	   public static void main(String args[]) throws IOException{

		   
		   //reading in the file
		   BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ianne\\eclipse-workspace\\LongestString\\src\\string_assignment.dat"));
		   
		   //getting the integer from the first line of the file for the main loop
		   int Fline = Integer.parseInt(reader.readLine());
		   
		   //declaring all the need variables
		   int L;
		   
		   String S;
		   
		   String s = "";
		   
		   String bS = "";
		   
		   int bPos = 0;
		   
		   //creating the list
		   List list = new LinkedList();
		   
		   //main loop
		   for (int i = 0; i < Fline; i++) {
			   
			   //adding all the elements to the list
			  for (int j = 0; j < 1; j++ ) {
				 S = reader.readLine();
				 L = Integer.parseInt(reader.readLine());
				 for (int k = 0; k < S.length(); k++) {
					  list.add(S.charAt(k));
				 }
				 
				 
				 //turning the main string to substrings of length L
				 for(int d = 0; d < list.size(); d++) {
					 
					 //declaring needed variables
					 int cPos = 0;
					 
					 //loop for creating substrings of length L
					for(int g = 0; g < L; g++) {
						
						//adding the chars to the substring of length L
						s += list.get(g);
						
					}
					
					//Finding the number of unique chars in each substring
				      int length;
				      String temp="";
				 
				      for (int v = 0; v < s.length(); v++) {
				         if(temp.indexOf(s.charAt(v)) == -1 ){
				             temp = temp + s.charAt(v);
				         }
				      }
				      
				      //finding the substring with the most unique chars
				      if (temp.length() > bPos) {
				    	  
				    	  bPos = temp.length();
				    	  bS = s;
				      }
				      

				     //Setting all variables back to 0 
				     s = "";
					 list.remove(0);
					 //increasing the current position
					 cPos++;
				 }
				 
				 //outputting the results
				 System.out.println(bS + " has the most unique characters with: " + bPos);
				 
				 //setting the best position back to 0 for the next loop
				 bPos = 0;
				 
				//removing all the elements in the current list to move on to the next string
				list.removeAll(list);
			  }
			
		   }
		   
		   reader.close();
		      
	 
	}
}
