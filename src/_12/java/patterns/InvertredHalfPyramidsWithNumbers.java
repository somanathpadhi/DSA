package _12.java.patterns;

// 1 2 3 4 5
// 1 2 3 4
// 1 2 3
// 1 2
// 1
public class InvertredHalfPyramidsWithNumbers {
    public static void main(String[] args) {
        invertredHalfPyramidsWithNumbers();
    }

    private static void invertredHalfPyramidsWithNumbers() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
