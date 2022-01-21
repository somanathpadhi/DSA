package _10.sorting.basic;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 5, 7, 9, 8};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cuu = arr[i];
            int lastIndexOfSortedArr = i - 1;

            while (lastIndexOfSortedArr >= 0 && cuu < arr[lastIndexOfSortedArr]) {
                arr[lastIndexOfSortedArr + 1] = arr[lastIndexOfSortedArr];
                lastIndexOfSortedArr--;
            }
            arr[lastIndexOfSortedArr + 1] = cuu;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
