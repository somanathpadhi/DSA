package _2.string;

public class ReverseString {

    public static void main(String[] args) {
        String str = "abcdft66";
        reverseString(str);
    }

    private static void reverseString(String str) {
        char[] charArray = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++;
            r--;
        }
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
    }
}
