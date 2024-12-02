package ADIlec13;

import java.util.Arrays;

public class Main {
    private static int[] memo;
    private static int[]tab;
    public static void main(String[] args) {
            int n=5;
            memo=new int[n+2];
            tab=new int[n+2];
        Arrays.fill(memo,-1);
        Arrays.fill(tab,-1);
        System.out.println(fibmemo(n));
        System.out.println(fibtab(n));

    }
    static int fibmemo(int n){
        if(n<=1) return n;

        if(memo[n] != -1) return memo[n];

        memo[n]=fibmemo(n-1)+fibmemo(n-2);
        return memo[n];
    }

    static int fibtab(int n){
        tab[0]=0;
        tab[1]=1;
        for(int i=2;i<=n;i++){
            tab[i] = tab[i-1] +tab [i-2];
        }
        return tab[n];
    }
}
