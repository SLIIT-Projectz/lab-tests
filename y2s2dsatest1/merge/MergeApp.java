package merge;

import java.util.Scanner;

public class MergeApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] even = {2, 4, 6};
		int[] odd = {1, 3, 5};
		
		Queue q1 = new Queue(3);
		Queue q2 = new Queue(3);
		
		try {
			for(int i=0; i<3; i++) {
				q1.insert(odd[i]);
				q2.insert(even[i]);
			}
			
			Stack s = new Stack(6);
			
			while(!s.isFull()) {
				s.push(q1.remove());
				s.push(q2.remove());
			}
			
			Queue qmerged = new Queue(6);
			while(!s.isEmpty()) {
				qmerged.insert(s.pop());
			}
			
			while(!qmerged.isEmpty()) {
				System.out.print(qmerged.remove() + " ");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		sc.close();
	}
}
