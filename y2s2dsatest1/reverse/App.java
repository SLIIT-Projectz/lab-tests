package reverse;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Queue q = new Queue(5);
		Stack s = new Stack(6);
		Scanner sc = new Scanner(System.in);
		char letter;

		// if you don't want try catch you can delete it and also delete those two Exception handling classes as well and follow the comments in Stack & Queue class.
		try {
			for(int i = 0; i < 5; i++) {
				System.out.print("Enter the letter " + (i+1 + ": "));
				letter = sc.next().charAt(0);
				q.insert(letter);
			}
			
			for(int i = 0; i < 5; i++) {
				s.push(q.remove());
			}
			
			while(!s.isEmpty()) {
				q.insert(s.pop());
			}
			
			System.out.println("\nReversed : ");
			while(!q.isEmpty()) {
				System.out.print(q.remove() + " ");
			}
		} catch(QueueStateException e) {
			System.out.println(e);
		} catch(StackStateException e) {
			System.out.println(e);
		}
		
		sc.close();
	}
}
