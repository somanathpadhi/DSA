package _24.recursion.advanced;

public class TotalPathInAMAzeFrom00ToNN {

    public static void main(String[] args) {
        int m = 30;
        int n = 30;
        System.out.println(totalPathInAMAzeFrom00ToNN(m,n,0,0));
    }

    private static int totalPathInAMAzeFrom00ToNN(int m, int n,int i, int j) {
        if (i == m || j == n){
            return 0;
        }
        if (i == m-1 && j == n -1){
            return 1;
        }
        int downPaths = totalPathInAMAzeFrom00ToNN(m,n,i+1,j);
        int rightPaths = totalPathInAMAzeFrom00ToNN(m,n,i,j+1);
        return downPaths+rightPaths;
    }
}
