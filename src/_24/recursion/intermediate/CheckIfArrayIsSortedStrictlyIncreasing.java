package _24.recursion.intermediate;

public class CheckIfArrayIsSortedStrictlyIncreasing {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(checkIfArrayIsSortedStrictlyIncreasing(arr,0));
    }

    private static boolean checkIfArrayIsSortedStrictlyIncreasing(int[] arr,int idx) {
        if (idx == arr.length-1) {
            return true;
        }

        if (arr[idx] < arr[idx+1]){
            return checkIfArrayIsSortedStrictlyIncreasing(arr,idx+1);
        }else {
            return false;
        }
    }
}
