package palindrome;

public class Queue {
	private int maxSize;
	private char[] queueArray;
	private int rear;
	private int front;
	private int noOfItems;
	
	public Queue(int size) {
		this.maxSize = size;
		this.queueArray = new char[size];
		this.front = 0;
		this.rear = -1;
		this.noOfItems = 0;
	}
	
	public void insert(char letter) throws StateException {
		if(!this.isFull()) {
			if(this.rear == this.maxSize -1) {
				rear = -1;
			}
			this.queueArray[++rear] = letter;
			this.noOfItems++;
		} else {
			throw new StateException("Queue is Full!");
		}
	}
	
	public char remove() throws StateException {
		if(!this.isEmpty()) {
			char letter = this.queueArray[front++];
			
			if(this.front == this.maxSize) {
				this.front = 0;
			}
			this.noOfItems--;
			return letter; 
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
