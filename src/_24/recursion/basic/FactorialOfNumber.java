package _24.recursion.basic;

public class FactorialOfNumber {
    public static void main(String[] args) {
        System.out.println(factorialOfNumber(5));
    }

    private static int factorialOfNumber(int i) {
        if (i ==1 || i == 0){
            return i;
        }
      // return i * factorialOfNumber(i-1);
       // or
        int factOfNMinusOne = factorialOfNumber(i -1);
        int factOfN = i * factOfNMinusOne;
        return factOfN;

    }
}
