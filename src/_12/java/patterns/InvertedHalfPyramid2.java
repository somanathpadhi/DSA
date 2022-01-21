package _12.java.patterns;

// * * * * *
//   * * * *
//     * * *
//       * *
//         *
public class InvertedHalfPyramid2 {
    public static void main(String[] args) {
        invertedHalfPyramid2();
    }

    private static void invertedHalfPyramid2() {
        for (int i = 1 ; i <=  5 ; i++){
            for (int j = 1 ; j < i ; j++){
                System.out.print("  ");
            }
            for (int j = 5 ; j >= i ; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
