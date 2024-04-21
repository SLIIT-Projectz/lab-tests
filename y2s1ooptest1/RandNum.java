import java.util.Random;

public class RandNum {
    int[][] numArray = new int[5][5];
    Random ran = new Random();
    int minimum, maximum, total = 0;
    double average;

    public RandNum(){
        for(int i = 0 ;i < 5; i++){
            for(int j = 0; j < 5; j++){
                numArray[i][j] = ran.nextInt(100);
                total += numArray[i][j];
            }
        }
    }

    public void calculateMinMaxAvg(){
        this.minimum = numArray[0][0];
        this.maximum = numArray[0][0];
        this.average = (double)total/25.0;

        for(int i = 0 ;i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(minimum > numArray[i][j]){
                    minimum = numArray[i][j];
                }

                if(maximum < numArray[i][j]){
                    maximum = numArray[i][j];
                }
            }
        }
    }

    public void display(){
        System.out.println("Minimum : " + this.minimum + "\nMaximum : " + this.maximum + "\nAverage : " + this.average);
    }

    public static void main(String[] args) {
        RandNum ob1 = new RandNum();
        ob1.calculateMinMaxAvg();
        ob1.display();
    }
}
