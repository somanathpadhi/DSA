package _2.string;

public class AllPermutaionOfString {
    public static void main(String[] args){
        String str = "abc";
        allPermutationsOfString(str,"");
    }

    private static void allPermutationsOfString(String str, String perm) {

        if (str.length() == 0){
            System.out.println(perm);
        }

        for (int i =0; i< str.length();i++){
            char charStr = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            allPermutationsOfString(newStr,perm+charStr);

        }






    }

}
