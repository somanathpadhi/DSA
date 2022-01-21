package _11.leetcode;

public class MaximumSubArray_53 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArrayBigOOfN(arr));
    }

    private static int maximumSubArrayBigOOfN(int[] arr) {
        int maxSum = arr[0];
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            current = current + arr[i];
            if (current > maxSum) {
                maxSum = current;
            }
            if (current < 0) {
                current = 0;
            }
        }
        return maxSum;
    }


    //O(n^2)
    private static int maximumSubArrayBigOOfNSquare(int[] arr) {
        int maximunSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = 0;
            for (int j = i; j < arr.length; j++) {
                current = current + arr[j];
                if (current > maximunSum) {
                    maximunSum = current;
                }
            }

        }
        return maximunSum;
    }
}

