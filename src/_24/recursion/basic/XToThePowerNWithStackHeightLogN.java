package _24.recursion.basic;

// Here height of stack is maintained to logN
public class XToThePowerNWithStackHeightLogN {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(xToThePowerN(x, n));
    }

    private static int xToThePowerN(int x, int n) {
        if (n == 0){
            return 1;
        }
        if (x == 0){
            return 0;
        }
        if (n % 2 == 0) {
            return xToThePowerN(x, n / 2) * xToThePowerN(x, n / 2);
        }
        else {
            return xToThePowerN(x, n / 2) * xToThePowerN(x, n / 2) * x;
        }
    }
}
