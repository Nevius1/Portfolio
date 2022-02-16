

public class LQueue<T>{
	
	private int size;
	private QueueNode<T> front;
	private QueueNode<T> back;
	
	
	
	
	
	public LQueue(){

		front = back = null;
		size = 0;
	}
	


	public T dequeue() {
		if(!isEmpty()) {
			T data =  (T) (new QueueNode(front)).getData();
			front = front.getNext();
			size--;
			return data;
		}
			
		return null;
	}


	public void enqueue(T e) {
		if(this.isEmpty()) {
			front = back = new QueueNode(e, null);
			size = 1;
		}
		else {
		//QueueNode<T> temp = new QueueNode(e, null);
		back.setNext(new QueueNode(e, null));
		back = back.getNext();
		size++;
		}
		
	}


	public T peek() {
		if(!isEmpty()) 
			return  (T) (new QueueNode(front)).getData();
		return null;
	}


	public int size() {
		return size;
	}


	public boolean isEmpty() {
		return size == 0;
	}

	
	private class QueueNode<S> {

		private S data;
		private QueueNode<S> next;
		
		
		public QueueNode(S data, QueueNode<S> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		/**copy constructor
		 * 
		 * @param next
		 */
		public QueueNode(QueueNode<S> node) {
			super();
			this.data = node.data;
			this.next = node.next;
		}
		
		public QueueNode(S data) {
			super();
			this.data = data;
			this.next = null;
		}
		
		
		public QueueNode() {
			super();
			this.data = null;
			this.next = null;
		}	
		


		public S getData() {
			return data;
		}

		public void setData(S data) {
			this.data = data;
		}

		public QueueNode<S> getNext() {
			return next;
		}

		public void setNext(QueueNode<S> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
   
		
		
		
}
	
	
}
