package _12.java.patterns;

//        *
//        * *
//        * * *
//        * * * *
public class HalfPyramid {
    public static void main(String[] args) {
        halfPyramid();
    }

    private static void halfPyramid() {
        for(int i = 0 ; i < 5 ; i ++){
            for (int j =0 ; j < i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
