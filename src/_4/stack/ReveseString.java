package _4.stack;

public class ReveseString {

    public static void main(String[] args) {
        String str = "leetcode";
       // System.out.println(myPow(2.0,10));
       // int[] nums = new int[]{0,2};
        //System.out.println(   missingNumber(nums));
        System.out.println(firstUniqChar(str));
    }
    public static int firstUniqChar(String s) {
        int[] intArr = new int[26];
        for(int i =0 ; i < s.length(); i++){
            intArr[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < s.length() ; i++){
            if(intArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            int temp  = xor ^ i;
            xor = temp ^ nums[i];
        }

        return xor ^ i;
    }

    private static String reverseString(String str) {
        char[] strArr = str.toCharArray();
        String strF = "";
        int firstIndex = 0;
        int lastIndex = str.length() - 1; //n+n
        while (firstIndex < lastIndex) {
            char temp = strArr[firstIndex];
            strArr[firstIndex] = strArr[lastIndex];
            strArr[lastIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
        for (int i = 0; i < strArr.length; i++) {
            strF = strF + strArr[i];
        }
        return strF;
    }

    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));

        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
