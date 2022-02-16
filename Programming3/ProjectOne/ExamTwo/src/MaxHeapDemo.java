
public class MaxHeapDemo {

	public static void main(String[] args) {
		MaxHeap<String> heap = new MaxHeap<String>();
		
		System.out.println("0) size = " +heap.getSize());
		System.out.println("0) Capacity = " + heap.getCapacity());
		
		
		heap.insert("Bob");
		heap.insert("Jane");
		heap.insert("Adam");
		heap.insert("Walt");
		heap.insert("Pete");
		heap.insert("Zack");
		
		System.out.println("1) size = " +heap.getSize());
		System.out.println("1) Capacity = " + heap.getCapacity());
			
		heap.insert("Sue");
		heap.insert("Jane");
		heap.insert("Janet");
		heap.insert("Kim");
		heap.insert("Pat");
		heap.insert("Dan");
		heap.insert("Erin");
		heap.insert("Sami");
		heap.insert("Adam");
		heap.insert("Zumba");
		heap.insert("Nancy");
		
		System.out.println("2) size = " +heap.getSize());
		System.out.println("2) Capacity = " + heap.getCapacity());

		System.out.println();
		heap.display();
		
		System.out.println();
		while(!heap.isEmpty())
			System.out.println(heap.remove());
		
	}

}
