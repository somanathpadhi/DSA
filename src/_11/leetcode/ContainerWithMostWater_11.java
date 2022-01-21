package _11.leetcode;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(arr.length);
        System.out.println( maxArea(arr));
        System.out.println( maxAreaWithTwoPointer(arr));
    }

    private static int maxAreaWithTwoPointer(int[] height) {
        int max = Integer.MIN_VALUE;
        int first = 0;
        int last = height.length-1;
        while(first < last){
            int temMax = (last - first) * Math.min(height[first],height[last]);
            if (temMax> max){
                max = temMax;
            }
            if (height[first] < height[last] ){
                first++;
            }else {
                last--;
            }
        }
        return max;
    }

    private static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < height.length-1 ; i++){
            for(int j = i+1; j < height.length; j++){
                if(height[i] < height[j]){
                    int tempMax = (j - i) * height[i];
                    if(tempMax > max){
                        max = tempMax;
                    }
                }else if(height[i] > height[j]){
                    int tempMax = (j- i) * height[j];
                    if(tempMax > max){
                        max = tempMax;
                    }
                }
                else if(height[i] == height[j]){
                    int tempMax = (j-i)* height[i];
                    if (tempMax > max){
                        max = tempMax;
                    }
                }
            }
        }
        return max;
    }
}
