package _24.recursion.basic;

public class PrintOneToFive {
    public static void main(String[] args) {
        int initialValue = 1;
        printOneToFive(initialValue);
    }

    private static void printOneToFive(int initialValue) {
        if (initialValue == 6){
            return;
        }
        System.out.print(initialValue);
        printOneToFive(initialValue+1);
    }
}
