package _2.string;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharacter {
    public static void main(String[] args){

        String str = "abacdssb";
        printDuplicateCharacter(str);

    }

    private static void printDuplicateCharacter(String str) {
        char[] charArr = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i =0 ; i<charArr.length;i++){
            if (!hm.containsKey(charArr[i])){
                hm.put(charArr[i],1);
            }
            else {
                hm.put(charArr[i],hm.get(charArr[i])+1);
            }
        }
        String resultStr = "";
        for (Map.Entry<Character,Integer> entry : hm.entrySet()){
            if (entry.getValue()>1){
                resultStr = resultStr+ entry.getKey();
            }
        }
        System.out.println(resultStr);
    }


//    private static void printDuplicateCharacter(String str) {
//        String duplicateCharStr = "";
//
//        for (int i = 0 ;i <str.length();i++) {
//            int count = 0;
//            for (int j =0 ; j <str.length();j++){
//                if (str.charAt(i) == str.charAt(j)){
//                    count++;
//                }
//            }
//            if (count>1){
//                duplicateCharStr = duplicateCharStr+str.charAt(i);
//            }
//        }
//        System.out.println(duplicateCharStr);
//    }


}
