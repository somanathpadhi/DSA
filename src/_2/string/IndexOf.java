package _2.string;

import java.util.Arrays;
import java.util.Random;

public class IndexOf {
    public static void main(String[] args){

        printNumber(10);





//        Random r = new Random();
//        int[] arr = {1,3,5,7,8,6};
//        for (int i = 0 ; i < arr.length -1 ; i++){
//            for (int j = 0 ; j < arr.length - i -1 ; j++){
//                if (arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] =  arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }

    }

    //main  ->  printNumber(5) ->printNumber(4) ->.. -> printNumber(3) printNumber(2) printNumber(1)



    public static void printNumber(int number){

        if (number == 0){
            return ;
        }
        System.out.println(number);
        printNumber(number-1);

    }
}
