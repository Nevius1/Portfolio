
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * T is required to have overridden the method equal
 * 
 * @author bgolshan
 *
 * @param <T>
 */
public class WDGraph<T> implements GraphADT<T> {

	private static int CAPACITY = 16; // can be changed to 16 later
	private double[][] adjMatrix;
	private int numEdges;
	private int numVertices;
	private T[] vertices;
	private final double INFINITY = Double.POSITIVE_INFINITY;
	private final int UNDEFINED = -1;

	public WDGraph(int capacity) {
		numVertices = 0;
		numEdges = 0;
		CAPACITY = capacity;
		adjMatrix = new double[capacity][capacity];
		vertices = (T[]) new Object[capacity];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				adjMatrix[i][j] = INFINITY;
			}

		}
	}

	public WDGraph() {
		this(CAPACITY);
	}

	@Override
	public int numVertices() {
		return numVertices;
	}

	@Override
	public int numEdges() {
		return numEdges;
	}

	@Override
	public void addVertex(T vertex) {
		if (numVertices == CAPACITY)
			expand();

		if (!existVertex(vertex)) {
			vertices[numVertices] = vertex;
			numVertices++;
		}

		// maybe an exception needs to be thrown when vertex already in graph

	}

	private void expand() {
		int newCapacity = 2 * CAPACITY;
		double[][] newAdjMatrix = new double[newCapacity][newCapacity];
		T[] newVertices = (T[]) new Object[newCapacity];

		for (int i = 0; i < numVertices; i++) {
			newVertices[i] = vertices[i];
		}

		for (int i = 0; i < newAdjMatrix.length; i++) {
			for (int j = 0; j < newAdjMatrix[i].length; j++) {
				newAdjMatrix[i][j] = INFINITY;
			}
		}

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				newAdjMatrix[i][j] = adjMatrix[i][j];
			}
		}

		CAPACITY = newCapacity;
		adjMatrix = newAdjMatrix;
		vertices = newVertices;

	}

	public String toString() {
		String result = "";

		int GAP = 5;
		if (isEmpty())
			return result;

		result += String.format("%7s", "");
		for (int i = 0; i < numVertices; i++) {
			result += String.format("%7s", vertices[i]);
		}

		result += "\n";
		for (int i = 0; i < numVertices; i++) {
			result += String.format("%7s", vertices[i]);

			for (int j = 0; j < numVertices; j++) {
				if (adjMatrix[i][j] == INFINITY)
					result += String.format("%7s", '\u221e');
				else
					result += String.format("%7.0f", adjMatrix[i][j]);
			}
			result += "\n";
		}

		return result;
	}

	/**
	 * The object type T should have overridden the .equals method
	 * 
	 * @param vertex
	 * @return only if the vertex already in graph
	 */
	private boolean existVertex(T vertex) {
		for (int i = 0; i < numVertices; i++) {
			if (vertex.equals(vertices[i]))
				return true;
		}
		return false;
	}

	@Override
	public void removeVertex(T vertex) {
		int index = vertexIndex(vertex);
		if (index == -1)
			return;

		int numEdgesRemoved = 0;
		for (int i = 0; i < numVertices; i++) {
			if (adjMatrix[index][i] != INFINITY)
				numEdgesRemoved++;
			if (adjMatrix[i][index] != INFINITY)
				numEdgesRemoved++;
		}

		numEdges -= numEdgesRemoved;

		// shift the columns left
		for (int col = index; col < numVertices - 1; col++) {
			for (int row = 0; row < numVertices; row++) {
				adjMatrix[row][col] = adjMatrix[row][col + 1];
			}
		}

		// shift the rows up
		for (int row = index; row < numVertices - 1; row++) {
			for (int col = 0; col < numVertices; col++) {
				adjMatrix[row][col] = adjMatrix[row + 1][col];
			}
		}

		// set last row and last columns to infinity
		for (int i = 0; i < numVertices; i++) {
			adjMatrix[numVertices - 1][i] = INFINITY;
			adjMatrix[i][numVertices - 1] = INFINITY;
		}
		// move vertices to the left
		for (int i = index; i < numVertices - 1; i++) {
			vertices[i] = vertices[i + 1];
		}
		vertices[numVertices - 1] = null; // nullify the last value
		numVertices--;

	}

	private int vertexIndex(T vertex) {
		for (int i = 0; i < numVertices; i++)
			if (vertices[i].equals(vertex))
				return i;

		return -1;
	}

	/**
	 * adds or updates an edge
	 * 
	 * @Override
	 */
	public void addEdge(T fromVertex, T toVertex, double weight) {
		if (this.existVertex(fromVertex) && this.existVertex(toVertex) && fromVertex != toVertex && weight > 0) {
			if (!this.existEdge(fromVertex, toVertex))
				numEdges++;
			adjMatrix[vertexIndex(fromVertex)][vertexIndex(toVertex)] = weight;
		}

	}

	@Override
	public boolean existEdge(T fromVertex, T toVertex) {
		return (existVertex(fromVertex) && existVertex(toVertex)
				&& adjMatrix[vertexIndex(fromVertex)][vertexIndex(toVertex)] != INFINITY);
	}

	@Override
	public void removeEdge(T fromVertex, T toVertex) {
		if (existVertex(fromVertex) && existVertex(toVertex) && existEdge(fromVertex, toVertex)) {
			numEdges--;
			adjMatrix[vertexIndex(fromVertex)][vertexIndex(toVertex)] = INFINITY;
		}
	}

	@Override
	public boolean isEmpty() {
		return numVertices == 0;
	}

	@Override
	public int numComponents() {
		int ver;
		int componentCount = 0;
		int tempVertex;
		int index;

		HashSet<Integer> S = new HashSet();
		Iterator<Integer> it;
		LQueue<Integer> que;
		List<T> ngbrs;

		for (int i = 0; i < numVertices; i++)
			S.add(i);

		while (!S.isEmpty()) {
			it = S.iterator();
			ver = it.next();
			S.remove(ver);

			componentCount++;
			que = new LQueue<Integer>();

			que.enqueue(ver);

			// BFS starting at the vertex ver

			while (!que.isEmpty()) {

				tempVertex = que.dequeue();
				ngbrs = neighbors(vertices[tempVertex]);
				if (ngbrs != null)
					for (T v : ngbrs) {

						index = vertexIndex(v);
						if (S.contains(index)) {
							S.remove(index);
							que.enqueue(index);
						}
					}
			}

		}

		return componentCount;

	}

	@Override
	public boolean existPath(T fromVertex, T toVertex) {
		if (!existVertex(fromVertex) || !existVertex(toVertex))
			return false;

		boolean[] visited = new boolean[numVertices]; // all values are initialized to false

		LQueue<T> que = new LQueue<T>();
		T tempVertex;
		List<T> ngbrs;

		que.enqueue(fromVertex);
		boolean done = false;
		visited[vertexIndex(fromVertex)] = true;

		while (!que.isEmpty() && !done) {
			if (que.peek().equals(toVertex)) {
				done = true;
				break;
			}
			tempVertex = que.dequeue();
			ngbrs = neighbors(tempVertex);

				for (T ver : ngbrs) {
					if (!visited[vertexIndex(ver)]) {
						visited[vertexIndex(ver)] = true;
						que.enqueue(ver);
					}
				}

		}

		return done;

	}



	/**
	 * Using the Dijkstra's shortest path alg, find the shortest
	 * path from the fromVertex to toVertex
	 * 
	 * @Override
	 */
	public ArrayList<T> shortestPath(T fromVertex, T toVertex) {
		HashSet<Integer> S = new HashSet<Integer>();
		double[] dist = new double[numVertices];
		int[] prev = new int[numVertices];
		
		int chosenVertexIndex;
		List<T> ngbrs;
		int indexV;
		double alt;
		ArrayList<T> path;
		
		for (int i = 0; i < numVertices; i++) {
			dist[i] = INFINITY;
			prev[i] = UNDEFINED;
			S.add(i);
		}
		
		dist[vertexIndex(fromVertex)] = 0;
		
		while(!S.isEmpty()) {
			chosenVertexIndex = nextChosenVertex(S, dist);
			//System.out.println("debug: " + chosenVertexIndex);
			if(chosenVertexIndex == -1)   //in case graph is disconnected
				break;
			S.remove(chosenVertexIndex);
			
		    ngbrs = neighbors(vertices[chosenVertexIndex]);	
		    
		    for(T v : ngbrs) {
		        indexV =  vertexIndex(v);   	
		    	if(S.contains(indexV)) {
		    		alt = dist[chosenVertexIndex] + adjMatrix[chosenVertexIndex][indexV];
		    		if (alt < dist[indexV]) {
		    			dist[indexV] = alt;
		    			prev[indexV] = chosenVertexIndex;
		    		}
		    		
		    	}
		    }
		}
		
		
		path = new ArrayList<T>();
		int index = vertexIndex(toVertex);
		if(dist[index] == INFINITY)
			return path;  //there is no path
		//else, there is a path.  Walk backwards and gather the vertices
		System.out.printf("Distance in feet: %.3f\n", dist[index]);
		while(prev[index] != UNDEFINED) {
			path.add(0, vertices[index]);
			index = prev[index];
		}
		path.add(0, vertices[index]);	
		
		return  path;
	}

	/**
	 * 
	 * @param S
	 * @param dist
	 * @return  the vertex in S with the smallest dist value 
	 */
	private int nextChosenVertex(HashSet<Integer> S, double[] dist) {
		double minValue = INFINITY;
		int smallest = -1;
		for(int v : S) {
			if(dist[v] <= minValue) {
				minValue = dist[v];
				smallest = v;
			}
		}
		return smallest;
	}
	
	


	@Override
	public List<T> neighbors(T vertex) {
		ArrayList<T> list = new ArrayList<T>();
		
		if(!existVertex(vertex))
			return null;
		int index = vertexIndex(vertex);
		
		for (int i = 0; i < numVertices; i++) {
		   if(adjMatrix[index][i] != INFINITY)
			   list.add(vertices[i]);
		}
		return list;
	}

}
