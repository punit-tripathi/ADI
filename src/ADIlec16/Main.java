package ADIlec16;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         int v=4;
         //adjacent matrix
         int[][] adjmat=new int[v+1][v+1];
         adjmat[0][1] =1;
         adjmat[0][3] =1;
         adjmat[1][0] =1;
         adjmat[1][2] =1;
         adjmat[2][1] =1;
         adjmat[3][0] =1;

         //adjacency list
        List<List<Integer>>adjlist=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjlist.add(new ArrayList<>());
        }
        adjlist.get(0).add(1);
        adjlist.get(0).add(3);
        adjlist.get(1).add(0);
        adjlist.get(1).add(2);
        adjlist.get(2).add(1);
        adjlist.get(3).add(0);
    }
}