package palindrome;

public class Stack {
	private char[] stackArray;
	private int maxSize;
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new char[size];
		this.top = -1;
	}
	
	public void push(char letter) throws StateException {
		if(!isFull()) {
			this.stackArray[++top] = letter;
		} else {
			throw new StateException("Stack is Full!");
		}
	}
	
	public char pop() throws StateException {
		if(!isEmpty()) {
			return this.stackArray[top--];
		} else {
			throw new StateException("Stack is Empty!");
		}
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == this.maxSize -1;
	}
}
