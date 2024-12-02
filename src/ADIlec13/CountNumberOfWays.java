package ADIlec13;

import java.util.Arrays;

public class CountNumberOfWays {
   private static int[] memo;
    public static void main(String[] args) {
        int n=12;
        memo=new int[n+2];

        Arrays.fill(memo,-1);
        System.out.println(CountNumberOfWay(n));
    }
    static int CountNumberOfWay(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;

        memo[n]=CountNumberOfWay(n-1)
                +CountNumberOfWay(n-2)
                +CountNumberOfWay(n-3);
        return memo[n];
    }

    static int CountNumberOfWaystab(int n){
              int[] tab=new int[n+1];
              tab[0]=1;

              for(int i=1;i<=n;i++){
                  tab[i] +=tab[i-1];
                  if(i >= 2) tab[i] += tab[i-2];
                  if(i >= 3) tab[i] += tab[i-3];
              }

              return tab[n];
    }
}
