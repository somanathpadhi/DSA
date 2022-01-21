package _24.recursion.intermediate;

import java.util.HashSet;

public class PrintAllTheUniqueSubsequenceOfString {
    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> hashSet = new HashSet<>();
        printAllTheUniqueSubsequenceOfString(str, 0, "", hashSet);
    }

    private static void printAllTheUniqueSubsequenceOfString(String str, int idx, String newStr, HashSet<String> hashSet) {
        if (idx == str.length()) {
            if (hashSet.contains(newStr)) {
                return;
            } else {
                System.out.println(newStr);
                hashSet.add(newStr);
                return;
            }
        }
        char ch = str.charAt(idx);
        printAllTheUniqueSubsequenceOfString(str, idx + 1, newStr + ch, hashSet);
        printAllTheUniqueSubsequenceOfString(str, idx + 1, newStr, hashSet);
    }
}
