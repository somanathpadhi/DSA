package _24.recursion.basic;

// Here height of stack is maintained to n
public class XToThePowerNWithStackHeightN {
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
        return  x * xToThePowerN(x,n-1);
        //or
//        int xPowerOfNMinusOne =  xToThePowerN(x, n-1);
//        int xPowerOfN = x * xPowerOfNMinusOne;
//        return xPowerOfN;
    }
}
