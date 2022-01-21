package _24.recursion.advanced;

//Input : m = 5, n = 2
//        Output : 6
//        The sequences are {1, 2}, {1, 3}, {1, 4},
//        {1, 5}, {2, 4}, {2, 5}

//{1, 2,4}, {1, 3}, {1, 4},
//        {1, 5}, {2, 4}, {2, 5}

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> ArrList = new ArrayList<Integer>();
        ArrList.add(1);
        allPermutations(5, 2,1, lists, ArrList);
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i) + " ");
        }
    }
    private static void allPermutations(int m, int n,int count, List<List<Integer>> lists, List<Integer> arrList) {
        if ( count == n  ) {
            lists.add(arrList);
            return;
        }
        for(int i = 1 ; i <= m ; i++){
            if ((i > (arrList.get(arrList.size() - 1) * 2)) || (i == (arrList.get(arrList.size() - 1) * 2))) {
                arrList.add(count+1);

                allPermutations(m, n,count+1, lists, arrList);
        }


        }
    }


//
//    public static void main(String[] args) {
//       // String str = "abc";
//        //stringPermutation(str, "");
//    }

//    private static void stringPermutation(String str, String perm) {
//        if (str.length() == 0) {
//            System.out.println(perm);
//            return;
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            char newPerm = str.charAt(i);
//            String newStr = str.substring(0, i) + str.substring(i + 1);
//            stringPermutation(newStr, perm + newPerm);
//        }
//    }
}
