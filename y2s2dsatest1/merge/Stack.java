package merge;

public class Stack {
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new int[size];
		this.top = -1;
	}
	
	public void push(int num) throws StateException {
		if(!this.isFull()) {
			this.stackArray[++top] = num;
		} else {
			throw new StateException("Stack is full!");
		}
	}
	
	public int pop() throws StateException {
		if(!this.isEmpty()) {
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
