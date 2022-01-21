package _24.recursion.intermediate;

import java.util.SplittableRandom;

public class KeypadCombination {
    public static String[] mapping = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) {
        String str = "23";
        keypadCombination(str, 0,"");
    }

    private static void keypadCombination(String str, int idx, String combination) {
        if (idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(idx);
        String mappings = mapping[currChar - '0'];
        for (int i = 0 ; i < mappings.length(); i++){
            keypadCombination(str,idx+1,combination+mappings.charAt(i));
        }
    }
}
