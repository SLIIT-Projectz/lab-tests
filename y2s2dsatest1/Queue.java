package quiz1;

public class Queue {
	private int maxSize;
	private char[] lettersArray;
	private int rear;;
	private int front;
	private int noOfItems;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.lettersArray = new char[maxSize];
		this.rear = -1;
		this.front = 0;
		this.noOfItems = 0;
	}

	public void insert(char letter) throws QueueStateException {
		if(!this.isFull()) {
			if(rear == maxSize - 1) {
				rear = -1;
			}
			
			this.lettersArray[++rear] = letter;
			this.noOfItems++;
		} else {
			// if you aren't interested in try catch throws you can simply delete this line and throws above and directly print it with sysout.
			throw new QueueStateException("Queue is Full");
		}
	}

	public char remove() throws QueueStateException {
		if(!this.isEmpty()) {
			char letter = this.lettersArray[front++];
			
			if(front == maxSize) {
				front = 0;
			}
			this.noOfItems--;
			return letter;
		} else {
			// if you aren't interested in try catch throws you can simply delete this line and throws above and directly print it with sysout.
			throw new QueueStateException("Queue is Empty");
		}
	}
	
	public boolean isEmpty() {
		return this.noOfItems == 0;
	}
	
	public boolean isFull() {
		return this.noOfItems == maxSize;
	}
}
