package merge;

public class Queue {
	private int maxSize;
	private int[] queueArray;
	private int rear;
	private int front;
	private int noOfItems;
	
	public Queue(int size) {
		this.maxSize = size;
		this.queueArray = new int[size];
		this.rear = -1;
		this.front = 0;
		this.noOfItems = 0;
	}
	
	public void insert(int num) throws StateException {
		if(!this.isFull()) {
			if(rear == maxSize -1) {
				rear = -1;
			}
			this.queueArray[++rear] = num;
			this.noOfItems++;
		} else {
			throw new StateException("Queue is Full!");
		}
	}
	
	public int remove() throws StateException {
		if(!this.isEmpty()) {
			int temp = this.queueArray[front++];
			if(front == maxSize) {
				front = 0;
			}
			this.noOfItems--;
			return temp;
		} else {
			throw new StateException("Queue is Empty!");
		}
	}
	
	public boolean isEmpty() {
		return this.noOfItems == 0;
	}
	
	public boolean isFull() {
		return this.noOfItems == this.maxSize;
	}

}
