package _12.java.patterns;

//        * * * *
//        * * *
//        * *
//        *
public class InvertedHalfPyramid {
    public static void main(String[] args) {
        invertedHalfPyramid();
    }

    private static void invertedHalfPyramid() {
        for (int i = 4 ; i > 0 ; i--){
            for (int j = i ; j > 0 ; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
