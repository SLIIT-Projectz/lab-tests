//most probably this will not come ... as this is String question.

public class CharArray {
    char[] myCharArray;

    public CharArray(char[] myCharArray){
        this.myCharArray = myCharArray;
    }

    public void swapFirstAndLast(){
        char temp = myCharArray[0];
        int len = myCharArray.length;
        for(int i = 0; i < (myCharArray.length/2); i++){
            char swapTemp = myCharArray[i];
            myCharArray[i] = myCharArray[len-i-1];
            myCharArray[len - i -1] = swapTemp;
        }
        myCharArray[len-1] = temp;
    }

    public void DisplayArray(){
        for(int i = 0; i < myCharArray.length; i++){
            System.out.println(myCharArray[i]);
        }
    }

    public void DisplayString(){
        String word = new String(myCharArray);
        System.out.println(word);
    }

    public static void main(String[] args) {
        char[] ar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        CharArray ob1 = new CharArray(ar);

        
        ob1.DisplayArray();
        ob1.swapFirstAndLast();
        ob1.DisplayString();
    }
}
