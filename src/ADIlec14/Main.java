package ADIlec14;

import java.util.Arrays;

public class Main {
    private static int[][] Dp;
    public static void main(String[] args) {


        int n=3;
        int[] wt={10,20,30};
        int[] val={60,100,120};
        int W=50;
        Dp = new int[n+1][W+1];
        for(int[] row:Dp){
            Arrays.fill(row,-1);
        }
        System.out.println(knapsack(wt,val,W,n));
    }
    static int knapsack(int[] wt,int[] val,int W,int n){
        if(n == 0 || W == 0) return 0;

        if(Dp[n][W] != -1) return Dp[n][W];
        if(wt[n-1] <= W ){
            Dp[n][W] = Math.max(val[n-1] + knapsack(wt,val,W-wt[n-1],n-1)
                    ,knapsack(wt,val,W,n-1));
        }
        else{
            Dp[n][W] =knapsack(wt,val,W,n-1);
        }
        return Dp[n][W];
    }
    static int Knapsacktab(int[] wt,int[] val,int W,int n){
        int[][] tab=new int[n+1][W+1];
        for(int i=0;i <= n;i++){
            for(int j=0;j <= W;j++){
                if(i == 0 || j == 0){
                    tab[i][j] = 0;
                }
                else{
                if(wt[i-1] < j){
                    tab[i][j] = Math.max(val[i-1] + tab[i-1][j-wt[i-1]],
                                tab[i-1][j]);
                }
                tab[i][j] = tab[i-1][j];
            }
            }
        }
        return tab[n][W];
    }
}
