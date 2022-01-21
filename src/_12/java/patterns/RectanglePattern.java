package _12.java.patterns;

//        * * * * *
//        * * * * *
//        * * * * *
//        * * * * *

public class RectanglePattern {
    public static void main(String[] args) {
        printRectanglePattern();
    }

    private static void printRectanglePattern() {
        for (int i = 0 ; i < 4 ; i++){
            for (int j = 1 ; j < 6 ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
