import java.util.Random;
import java.util.Scanner;

public class Lottery {
    private int[] lotteryNumbers = new int[5];

    public Lottery() {
        Random ran = new Random();

        for (int i = 0; i < 5; i++) {
            lotteryNumbers[i] = ran.nextInt(10);
        }
    }

    public int compareLottery(int[] numbers) {
        int matchNumbers = 0;

        for (int i = 0; i < 5; i++) {
            if (lotteryNumbers[i] == numbers[i]) {
                matchNumbers++;
            }
        }
        return matchNumbers;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] userNumbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the Lottery Number " + (i + 1) + " : ");
            userNumbers[i] = sc.nextInt();
        }

        Lottery lottery = new Lottery(); 
        System.out.println("\nTotal matched numbers are : " + lottery.compareLottery(userNumbers));
    }
}
