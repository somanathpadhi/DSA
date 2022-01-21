package _14.backtracking;

//O(n * n!)
public class AllPermutationString {
    public static void main(String[] args) {
        String str = "abc";
        allPermutationString(str, "");
    }

    private static void allPermutationString(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i + 1);
            allPermutationString(newString, perm + ch);
        }
    }
}
