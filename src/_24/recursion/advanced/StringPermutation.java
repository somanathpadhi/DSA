package _24.recursion.advanced;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "abc";
        stringPermutation(str, "");
    }

    private static void stringPermutation(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char newPerm = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            stringPermutation(newStr, perm + newPerm);
        }
    }
}
