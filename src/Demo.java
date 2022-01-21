import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        int a = 9 ;
        int b = 2;
        HashMap obj = new HashMap();
        obj.put("A", 1);
        System.out.println(9 & 2);
//        String[] str = {"flower","flow","flight"};
//        longestCommonPrefix(str);
//        System.out.println();
    }

    public static void longestCommonPrefix(String[] strs) {


        String pre = "flower";
        System.out.println(strs[1].indexOf(pre));
        pre = pre.substring(0,pre.length()-1);
        System.out.println(pre);
//        if(strs == null || strs.length == 0)    return "";
//        String pre = strs[0];
//        int i = 1;
//        while(i < strs.length){
//            while(strs[i].indexOf(pre) != 0)
//                pre = pre.substring(0,pre.length()-1);
//            i++;
//        }
//        return pre;

    }
}
