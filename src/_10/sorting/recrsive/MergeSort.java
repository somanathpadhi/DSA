package _10.sorting.recrsive;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2};

        mergeSort(arr);

        System.out.print("After Sort");
        for (int value : arr) {
            System.out.print(value);
        }
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }


    private static void mergeSort(int[] arr, int lowerBound, int upperBound, int[] temp) {

        if (lowerBound < upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            mergeSort(arr, lowerBound, mid, temp);
            mergeSort(arr, mid + 1, upperBound, temp);
            merge(arr, lowerBound, mid, upperBound, temp);
        }
    }

    private static void merge(int[] arr, int lowerBound, int mid, int upperBound, int[] temp) {

        int i = lowerBound;
        int k = lowerBound;
        int j = mid + 1;
        while (i <= mid && j <= upperBound) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        if (i > mid) {
            while (j <= upperBound) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                temp[k] = arr[i];
                i++;
                k++;
            }
        }

        for (int t = lowerBound; t <= upperBound; t++) {
            arr[t] = temp[t];
        }
    }
}
