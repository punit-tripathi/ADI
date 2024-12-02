package ADIlec19;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    void Dijkstras(List<List<int[]>> adjlist,int src){
        int vertices=adjlist.size();
        int[] dist=new int[vertices+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b) -> a[0] - b[0]);
        dist[src]=0;
        q.add(new int[]{0,src});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int u=arr[1];
            for(int[] nei:adjlist.get(u)){
                int v=nei[0];
                int weight=nei[1];

                if(dist[v] > dist[u] + weight && dist[u] != Integer.MAX_VALUE){
                    dist[v] = dist[u] + weight;
                    q.add(new int[]{dist[v],v});
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]);
        }
    }
}
