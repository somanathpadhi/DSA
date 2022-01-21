package _24.recursion.advanced;

import java.util.ArrayList;

// O(2^n)
public class SubSetOfSetOfFirstNNaturalNumbers {
    public static void main(String[] args) {
        int n = 3 ;
        ArrayList<Integer> subset = new ArrayList<>();
        subSetOfSetOfFirstNNaturalNumbers(n, subset);
    }

    private static void printSubSet(ArrayList<Integer> subset) {
        for (int i = 0 ; i < subset.size() ; i++){
            System.out.print(subset.get(i));
        }
        System.out.println();
    }
    private static void subSetOfSetOfFirstNNaturalNumbers(int n, ArrayList<Integer> subset) {

        if (n == 0){
            printSubSet(subset);
            return;
        }
        // if added
        subset.add(n);
        subSetOfSetOfFirstNNaturalNumbers(n-1,subset);
        // not added
        subset.remove(subset.size()-1);
        subSetOfSetOfFirstNNaturalNumbers(n-1,subset);

    }


}
