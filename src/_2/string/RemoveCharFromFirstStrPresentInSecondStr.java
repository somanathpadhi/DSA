package _2.string;

import java.util.LinkedHashSet;

// 20th Dec 2021

public class RemoveCharFromFirstStrPresentInSecondStr {
    public static void main(String[] args) {
        String str1 = "abcdefgh";
        String srt2 = "acfh";

        updatedString(str1, srt2);

    }

    private static void updatedString(String firstStr, String secondStr) {
        char[] charStr1 = firstStr.toCharArray();
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for (int i = 0; i < charStr1.length; i++) {

            if (!lhs.contains(charStr1[i])) {
                lhs.add(charStr1[i]);
            }
        }
        char[] charStr2 = secondStr.toCharArray();
        for (int i = 0; i < charStr2.length; i++) {
            if (lhs.contains(charStr2[i])) {
                lhs.remove(charStr2[i]);
            }
        }
        for (char ch : lhs){
            System.out.print(ch);
        }

    }
}
