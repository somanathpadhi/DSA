package _24.recursion.intermediate;

public class AllSubSequenceOfString {
    public static void main(String[] args) {
        String str = "abcd";
        allSubSequenceOfString(str,0,"");
    }

    private static void allSubSequenceOfString(String str, int idx, String newStr) {

        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(idx);
        allSubSequenceOfString(str,idx+1,newStr+ ch);
        allSubSequenceOfString(str,idx+1,newStr);
    }
}
