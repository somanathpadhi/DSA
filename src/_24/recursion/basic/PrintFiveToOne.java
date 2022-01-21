package _24.recursion.basic;

public class PrintFiveToOne {
    public static void main(String[] args) {
        int initialValue = 5;
        printFiveToOne(initialValue);
    }

    private static void printFiveToOne(int initialValue) {
        if (initialValue ==0){
            return;
        }
        System.out.print(initialValue);
        printFiveToOne(initialValue-1);
    }
}
