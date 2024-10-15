package ADILec5;

public class main {
    public static void main(String[] args) {
        String s1="ABCDE";
        String s2="BCDEH";

        int n1=s1.length();
        int n2=s2.length();

        System.out.println(longestCommonSubSeq(s1,s2,n1,n2));

    }
    static int longestCommonSubSeq(String s1,String s2,int n1,int n2){

        if(n1 == 0 || n2 == 0) return 0;
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return 1+longestCommonSubSeq(s1,s2,n1-1,n2-1);
        }
        return Math.max(longestCommonSubSeq(s1,s2,n1-1,n2),longestCommonSubSeq(s1,s2,n1,n2-1));
    }
}
