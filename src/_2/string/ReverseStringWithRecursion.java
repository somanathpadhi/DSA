package _2.string;

// 20th Dec 2021
public class ReverseStringWithRecursion {
    public static void main(String[] args){
        String str = "abcdefghijklmnopqrstuvwxyz";
        reverseStringWithRecursion(str);

    }

    private static void reverseStringWithRecursion(String str) {

        if (str.length()<1){
            return;
        }
        reverseStringWithRecursion(str.substring(0,0)+str.substring(1));
        System.out.print(str.charAt(0)+" ");
    }
}
