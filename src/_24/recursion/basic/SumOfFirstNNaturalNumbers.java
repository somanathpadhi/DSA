package _24.recursion.basic;

public class SumOfFirstNNaturalNumbers {
    public static void main(String[] args) {
        sumOfFirstNNaturalNumbers(1,5,0);
    }

    private static void sumOfFirstNNaturalNumbers(int i, int n, int sum) {
        if(i ==n){
            sum = sum+i;
            System.out.println(sum);
            return;
        }
        sum = sum+i;
        sumOfFirstNNaturalNumbers(i+1, n, sum);
    }
}
