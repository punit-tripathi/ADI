package ADIlec14;

import java.util.Arrays;
import java.util.Stack;

public class LCS {
    private static int[][] Dp1;
    public static void main(String[] args) {
              String s1="ABCDE";
              String s2="ACE";
              int n1=5;
              int n2=3;
              Dp1=new int[n1+1][n2+1];
              for(int[] row:Dp1){
                  Arrays.fill(row,-1);
              }

        System.out.println(LCShelper(s1,s2,n1,n2));

    }
    static int LCShelper(String s1,String s2,int n1,int n2){
        if(n1 == 0 || n2 == 0) return 0;

        if(Dp1[n1][n2] != -1) return Dp1[n1][n2];
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            Dp1[n1][n2] = 1+LCShelper(s1,s2,n1-1,n2-1);
        }
        else{
            Dp1[n1][n2]=Math.max(LCShelper(s1,s2,n1-1,n2),
                    LCShelper(s1,s2,n1,n2-1));
        }
        return Dp1[n1][n2];
    }
    static int LCStab(String s1,String s2,int n1,int n2){
        int[][] tab=new int[n1+1][n2+1];

        for(int i=1;i <= n1;i++){
            for(int j=1;j <= n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    tab[i][j]=1+tab[i-1][j-1];
                }
                else{
                    tab[i][j] = Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return tab[n1][n2];
    }
}
