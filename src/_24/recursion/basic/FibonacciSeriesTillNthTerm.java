package _24.recursion.basic;

public class FibonacciSeriesTillNthTerm {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int n = 10;
        System.out.print(a + " ");
        System.out.print(b + " ");
        fibonacciSeriesTillNthTerm(a, b, n - 2);
    }

    private static void fibonacciSeriesTillNthTerm(int first, int second, int n) {
        if (n ==0){
            return;
        }
        int next = first+ second;
        System.out.print(next + " ");
        fibonacciSeriesTillNthTerm(second,next,n-1);
    }
}
