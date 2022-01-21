package _2.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxOccurrenceChar {
    public static void main(String[] args){
        String str = "abcadabbb";
        maxOccurrenceChar(str);
    }


    private static void maxOccurrenceChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (int i = 0; i<charArray.length;i++){
            if (hm.containsKey(charArray[i])){
                hm.put(charArray[i], hm.get(charArray[i]) +1);
            }
            else {
                hm.put(charArray[i],1);
            }
        }

        Set<Map.Entry<Character,Integer>> entrySet = hm.entrySet();
        int maxValue = 0;
        char maxChar =0;
        for (Map.Entry<Character,Integer> entry : entrySet){
            if (entry.getValue()> maxValue){
                maxValue = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println(" "+maxChar+" "+ " "+maxValue);
    }

//    private static void maxOccurrenceChar(String str) {
//        char[] charArray= str.toCharArray();
//        int maxCount = 0;
//        char maxOccChar = 0;
//
//        for (int i = 0; i<charArray.length;i++){
//            int count = 0;
//            for (int j = 0; j<charArray.length;j++){
//                if (charArray[i] == charArray[j]){
//                    count++;
//                }
//            }
//            if (count>maxCount){
//                maxCount = count;
//                maxOccChar = charArray[i];
//            }
//        }
//        System.out.println("maxOccurrenceChar - "+maxOccChar+" "+maxCount);
//    }

}
