import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VertexTester {

	public static void main (String args[]) throws FileNotFoundException {
		
		
		//Creating the file object and the scanner
		File data = new File("src\\map.dat");
		Scanner sc = new Scanner(data);
		
		//reading the first integer for the number of vertices
		int aLength = sc.nextInt();
		sc.nextLine();
		//Creating the vertex array list and the graph to go with it
		ArrayList<Vertex> verticies = new ArrayList();
		WDGraph<Integer> graph = new WDGraph<Integer>();
		
		//first for loop for reading all the vertices
		for (int i = 0; i <= aLength -1; i++) {
			sc.useDelimiter(",");

			//reading the file
			String line = sc.nextLine();
			String[] test = line.split(",");
			Vertex temp = new Vertex();
			//System.out.println(test[0] + " " + test[4]);
			
			//adding the data to the vertices
			temp.setId(Integer.parseInt(test[0]));
			temp.setLatitude(Double.parseDouble(test[2]));
			temp.setLongitude(Double.parseDouble(test[1]));
			temp.setHeight(Double.parseDouble(test[3]));
			temp.setName(test[4]);
			verticies.add(temp);
		}
		
		
		
		//adding the vertices to the array list
		for(int k = 0; k < verticies.size(); k++) {
			int temp = verticies.get(k).getId();
			graph.addVertex(temp);
		}
		
		//getting the next int for the number of edges 
		String eLine = sc.nextLine();
		int eLength = Integer.parseInt(eLine);
		Double[] dist = new Double[eLength];
		//for loop for edges
		for (int h = 0; h < eLength; h++) {
			
			//reading the data
			String line = sc.nextLine();
			String[] test = line.split(" ");
			//getting the data out of the array
			int tempone = Integer.parseInt(test[1]);
			int temptwo = Integer.parseInt(test[0]);
			int tempthree = Integer.parseInt(test[2]);
		
			//calculating the distances
			double distance = distanceInKmBetweenEarthCoordinates(verticies.get(tempone).getLatitude(), verticies.get(tempone).getLongitude(), verticies.get(temptwo).getLatitude(), verticies.get(temptwo).getLongitude());
			
			//adding the edges to the graph
			graph.addEdge(tempone, temptwo, distance);
			//checking if they are a two way street
			 if (tempthree == 2) {
			graph.addEdge(temptwo, tempone, distance);
			 }
			 
		}
		
		//Reading the next int for the number of cases
		String temp = sc.nextLine();
		int numCases = Integer.parseInt(temp);
		System.out.println("Distances in feet");
		//for loop for number of cases
		for (int g = 0; g < numCases; g++) {
			
			//reading the data
			String line = sc.nextLine();
			String[] test = line.split(" ");
			//getting the data from the array
			int tempone = Integer.parseInt(test[0]);
			int temptwo = Integer.parseInt(test[1]);
			
			//Output
			System.out.println("Path number " + (g + 1) + ":");
			
			ArrayList<Integer> path = graph.shortestPath(tempone, temptwo);
			


			for (Integer b : path) {

				System.out.println(verticies.get(b).getName() + " " + verticies.get(b).getId());
				
			}
			
			System.out.println();

		}
		
		System.out.println(graph);
		
		
	}
	//distance methods
	public static double degreesToRadians(double degrees) {
		  return degrees * Math.PI / 180;
		}
	
	public static double distanceInKmBetweenEarthCoordinates(double lat1, double lon1, double lat2, double lon2) {
		  var earthRadiusKm = 6371;

		  var dLat = degreesToRadians(lat2-lat1);
		  var dLon = degreesToRadians(lon2-lon1);

		  lat1 = degreesToRadians(lat1);
		  lat2 = degreesToRadians(lat2);

		  var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		          Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
		  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		  return (earthRadiusKm * c) * 3280.84;
		}
	
}
