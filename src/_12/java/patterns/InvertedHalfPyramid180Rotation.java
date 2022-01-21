package _12.java.patterns;

//           *
//         * *
//       * * *
//     * * * *

public class InvertedHalfPyramid180Rotation {
    public static void main(String[] args) {
        invertedHalfPyramid180Rotation();
    }

    private static void invertedHalfPyramid180Rotation() {
        for (int i = 1 ; i <= 4 ; i++){
            for (int j = 1 ; j <= 4 -i ; j++){
                System.out.print("  ");
            }
            for (int j = 1 ; j <= i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
