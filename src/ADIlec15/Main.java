package ADIlec15;

import java.util.Arrays;

public class Main {
    private static int[][] Dp;
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int n=5;
        Dp=new int[n+1][n+1];
        for(int[] row:Dp){
            Arrays.fill(row,-1);
        }
        MCM(arr,1,n-1);
    }
    static int MCM(int[] arr,int i,int j){
        if(i == j) return 0;

        if(Dp[i][j] != -1) return Dp[i][j];
        int minimum=Integer.MAX_VALUE;
        for(int k=i;k < j;k++){
           int currmin= MCM(arr,i,k)+MCM(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
//           minimum=Math.min(minimum,currmin);
            if(currmin < minimum){
                minimum=currmin;
            }
        }
        Dp[i][j]=minimum;
        return Dp[i][j];
    }

}
