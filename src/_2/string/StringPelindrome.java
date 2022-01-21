package _2.string;

public class StringPelindrome {
    public static void main(String[] args) {
        String arr = "abbbba";
        System.out.println(isStringPalindrome(arr));

    }

    private static Boolean isStringPalindrome(String arr) {
        int l = 0;
        int r = arr.length() - 1;
        while (l < r) {
            if (arr.charAt(l) == arr.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }

        }
        return true;
    }
}
