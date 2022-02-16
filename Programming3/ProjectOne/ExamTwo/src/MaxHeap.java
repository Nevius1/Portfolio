
public class MaxHeap <E extends Comparable<E>>{
	
	//data members
	private E[] heap;
	private int size;    //number of elements in the heap
	private int capacity;  //capacity of the heap
	
	private int INITIAL_CAPACITY = 16;
	
	
	public MaxHeap() {
		heap = (E[]) new Comparable[INITIAL_CAPACITY];
		
		size = 0;
		capacity = INITIAL_CAPACITY;
	}


	/**
	 * remove and return the top element of the heap
	 * 
	 * @return
	 */
	public E remove() {
		if(isEmpty())
			return null;
		
		E topElement = heap[0];
		
		heap[0] = heap[size-1];
		size--;
		
		//have heap[0] sift downward
		
		int i = 0;
		E temp;
		while(true) {
			
			//if i is not a valid index or node is a leaf node, terminate
			if(i >= size || hasNoChildern(i))
				break;
			
			if(hasBothChilren(i)) {
				//if this is greater than both its children, terminate loop
				if(heap[i].compareTo(heap[2*i+1]) >=0 &&
						heap[i].compareTo(heap[2*i+2]) >=0 )
					break;
				
				else if (heap[2*i+1].compareTo(heap[2*i+2]) >= 0) {
					//left child is the larger one.  Swap node with that one
					temp = heap[2*i+1];
					heap[2*i+1] = heap[i];
					heap[i] = temp;
					i = 2*i+1;   //move to left child position
					
				}
				else {
					//right child is the larger one. Swap node with that one
					temp = heap[2*i+2];
					heap[2*i+2] = heap[i];
					heap[i] = temp;
					i = 2*i+2;		//move to right child position
				}
					
			}
			
			else if(hasLeftChild(i)  && heap[i].compareTo(heap[2*i + 1]) < 0){
				//node is smaller than its only child.  Swap the them
				temp = heap[i];
				heap[i] = heap[2*i + 1];
				heap[2*i + 1] = temp;
				i = 2*i + 1 ;   
			}
			else
				break;   //node is already larger than its only child
			
		}
		
		
		
		return topElement;
	}
	
	
	
	private boolean hasBothChilren(int i) {
		return 2*i + 2 < size;
	}
	
	private boolean hasLeftChild(int i) {
		return 2*i + 1 < size;
	}
	
	private boolean hasNoChildern(int i) {
		return 2*i + 1 >= size;
	}
	
	
	public void insert (E e) {
		
		if(size == capacity)
			increaseCapacity();

		heap[size] = e;
		int i = size;
		E temp;
		
		while(true) {
			if(heap[i].compareTo(heap[(i-1)/2]) <= 0) 
				break;
			
			else {
				//swap heap[i] with its parent node
				temp = heap[i];
				heap[i] = heap[(i-1)/2];
				heap[(i-1)/2] = temp;
			}
			i = (i - 1) /2;
			if(i == 0)
				break;
				
		}
		size++;
	}
	
	
	
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	

	/**
	 * double the capacity of the heap array
	 * Move the old values to the new array
	 * 
	 * O(n)
	 * 
	 */
	private void increaseCapacity() {
		int newCapacity = capacity * 2;
		E[] newHeap = (E[]) new Comparable[newCapacity];
		
		for (int i = 0; i < size; i++) 
			newHeap[i] = heap[i];
		
		heap = newHeap;
		capacity = newCapacity;		
	}
	
	
	/**
	 * for testing purposes only
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(heap[i]);
			
		}
	}

}
