package reverse;

public class Stack {
	private int maxSize;
	private char[] lettersArray;
	private int top;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.lettersArray = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char letter) throws StackStateException {
		if(!this.isFull()) {
			this.lettersArray[++top] = letter;
		} else {
			// if you aren't interested in using try catch throws you can simply delete this line and throws above and directly print it with sysout.
			throw new StackStateException("Stack is Full");
		}
	}
	
	public char pop() throws StackStateException {
		if(!this.isEmpty()) {
			return this.lettersArray[top--];
		} else {
			// if you aren't interested in using try catch throws you can simply delete this line and throws above and directly print it with sysout.
			throw new StackStateException("Stack is Empty");
		}
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize -1;
	}
}