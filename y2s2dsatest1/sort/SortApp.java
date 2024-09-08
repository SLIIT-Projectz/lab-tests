package sort;

public class SortApp {

	public static void main(String[] args) {
		int[] numbers = {3, 1, 4, 2};
		int temp;
		
		Queue unsorted = new Queue(numbers.length);
		Stack s = new Stack(numbers.length);
		
		try {
			for(int i=0; i<numbers.length; i++) {
				unsorted.insert(numbers[i]);
			}
			
			while(!unsorted.isEmpty()) {
				temp = unsorted.remove();
				
				while(!s.isEmpty() && s.peek() > temp) {
					unsorted.insert(s.pop());
				}
				
				s.push(temp);
			}
			
			while(!s.isEmpty()) {
				unsorted.insert(s.pop());
			}
			
			while(!unsorted.isEmpty()) {
				System.out.println(unsorted.remove());
			}
		} catch(Exception e) {
			System.out.println(e);
		}

	}

}