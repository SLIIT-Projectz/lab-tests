package sort;

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
			throw new StateException("Stack is Full!");
		}
	}
	
	public int pop() throws StateException {
		if(!this.isEmpty()) {
			return this.stackArray[top--];
		} else {
			throw new StateException("Stack is Empty!");
		}
	}
	
	public int peek() {
		return this.stackArray[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize -1;
	}

}
