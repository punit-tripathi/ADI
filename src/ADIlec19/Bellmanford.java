package ADIlec19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bellmanford {
    void bellmanford(ArrayList<ArrayList<Integer>> edges,int V,int src){
        int[] dist=new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> edge:edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int weight=edge.get(2);
                if(dist[v] > dist[u] + weight && dist[u] != Integer.MAX_VALUE){
                    dist[v] = dist[u] + weight;
                }
            }
        }
        for(int i=0;i< dist.length;i++){
            System.out.println(dist[i]);
        }
    }
}
