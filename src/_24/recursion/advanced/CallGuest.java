package _24.recursion.advanced;

public class CallGuest {
    public static void main(String[] args) {
        int n =4;
        System.out.println(callGuest(n));
    }

    private static int callGuest(int n) {

        if ( n <= 1 ){
            return 1;
        }

        int singleWay = callGuest(n-1);
        int pairWay = (n-1) * callGuest(n-2);
        return singleWay + pairWay;
    }
}
