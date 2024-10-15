package ADIlec2;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        //Given a string find its first nonrepeating element index and return
        //if not return -1;
        String s="ABABDfGfk";
        Map<Character,Integer>mpp=new HashMap<>();
        int res=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(mpp.get(s.charAt(i)) == 1){
                res=i;
                break;
            }
        }
        System.out.println(res);


        //Given a string find the length of longest substring with non repeating charac.
            String s1="ABAAB";
            int maxLength=0; int st=0;
            Map<Character,Integer>mpp1=new HashMap<>();
            for(int i=0;i<s1.length();i++){
                char ch1=s1.charAt(i);
                if(mpp.containsKey(ch1)){
                    st=Math.max(mpp.get(ch1)+1,st);
                }
                mpp.put(ch1,i);
                maxLength=Math.max(maxLength,i-st+1);
            }
        System.out.println("maxlength "+maxLength);
        //given an array and a target find the index of two element in the array
        //whose sum is equal to target

    }
}
