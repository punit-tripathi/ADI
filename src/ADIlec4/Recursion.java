package ADIlec4;

public class Recursion {
    public static void main(String[] args) {
        int n=7;
        System.out.println(fact(n));

    }
   static int fact(int n){

        if(n == 1 || n == 0){
            return 1;
        }

        return n*fact(n-1);
    }

    static int fib(int n){

        if(n <= 1) return n;

        return fib(n-1) + fib(n-2);
    }
}
