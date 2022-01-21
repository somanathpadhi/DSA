package _24.recursion.intermediate;

public class RemoveDuplicateFromTheString {
    public static boolean[] map = new boolean[26];
    public static void main(String[] args) {
        String str = "abbccda";
        removeDuplicateFromTheString(str,0,"");

    }

    private static void removeDuplicateFromTheString(String str, int idx, String newString) {

        if (idx == str.length()){
            System.out.println(newString);
            return;
        }

        char ch = str.charAt(idx);
        if(!map[ch -'a']){
            map[ch -'a'] = true;
            newString +=ch;
            removeDuplicateFromTheString(str,idx+1,newString);
        }
        else {
            removeDuplicateFromTheString(str,idx+1,newString);
        }
    }

//    private static void removeDuplicateFromTheString2(String str, int idx, String newStr) {
//
//        if (idx == str.length()){
//            System.out.println(newStr);
//            return;
//        }
//        if (!newStr.contains(str.charAt(idx)+"")){
//            newStr+=str.charAt(idx);
//            removeDuplicateFromTheString(str,idx+1,newStr);
//        }else {
//            removeDuplicateFromTheString(str,idx+1,newStr);
//        }
//    }
}
