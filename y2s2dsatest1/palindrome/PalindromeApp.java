package palindrome;

import java.util.Scanner;

public class PalindromeApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text;
		int length;
		char letter;
		boolean palindrome = true;
		
		System.out.println("Enter the text : ");
		text = sc.nextLine();
		
		text = text.replaceAll("\\s", "").toLowerCase();
		length = text.length();
		
		Stack s = new Stack(length);
		Queue q = new Queue(length);
		
		try {
			for(int i = 0; i < length; i++) {
				letter = text.charAt(i);
				s.push(letter);
				q.insert(letter);
			}
			
			while(!s.isEmpty()) {
				if(s.pop() != q.remove()) {
					System.out.println("It is not palindrome");
					palindrome = false;
					return;
				}
				
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		if(palindrome) {
			System.out.println("It is palindrome");
		}
		
		sc.close();
	}

}
