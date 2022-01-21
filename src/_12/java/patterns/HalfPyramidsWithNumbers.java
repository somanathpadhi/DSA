package _12.java.patterns;

// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5
public class HalfPyramidsWithNumbers {
    public static void main(String[] args) {
        halfPyramidsWithNumbers();
    }

    private static void halfPyramidsWithNumbers() {
        for (int i = 1 ; i <= 5 ; i++){
            for (int j = 1 ; j <= i ; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
