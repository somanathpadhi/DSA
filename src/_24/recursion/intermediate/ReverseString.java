package _24.recursion.intermediate;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Somanath";
        reverseString(str, str.length()-1);
    }

    private static void reverseString(String str, int index) {
        if (index == 0){
            System.out.print(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        reverseString(str,index-1);

    }
}
