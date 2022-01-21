package _2.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicateFromString {

    public static void main(String[] args) {
        String str = "aabbrrrtgcvhdgdjcc";
        removeDuplicate(str);
        //removeDuplicateHm(str);

    }

    private static void removeDuplicateHm(String str) {
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();

        char[] charStr = str.toCharArray();
        int s = 0;

        while (s < charStr.length) {
            if (!lhm.containsKey(charStr[s])) {
                lhm.put(charStr[s], 1);
            }
            s++;
        }
        String result = "";
        for (Map.Entry<Character, Integer> entry : lhm.entrySet()) {
            result = result + entry.getKey();
        }

        System.out.println(result);
    }


    private static void removeDuplicate(String str) {

        String nonDuplicateString = "";
        for (int i = 0; i < str.length(); i++) {

            if (!nonDuplicateString.contains(str.charAt(i) + "")) {
                nonDuplicateString = nonDuplicateString + str.charAt(i);
            }
        }
        System.out.println(nonDuplicateString);
    }
}
