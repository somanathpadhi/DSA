package _11.leetcode;

public class ReverseString_344 {
    public static void main(String[] args){
        char[] charArr = {'h','e','l','l','o'};
        System.out.println(reverseString(charArr));
    }

    private static char[] reverseString(char[] charArr) {
        int l = 0;
        int r = charArr.length-1;
        while (l<r){
            char temp = charArr[r];
            charArr[r] = charArr[l];
            charArr[l] = temp;
            l++;
            r--;
        }
        return charArr;
    }
}
