package ADIlec20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    public static void main(String[] args) {

    }
    public static void kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
                ds.union(edge.src, edge.dest);
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
        for (Edge edge : mstEdges) {
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " with weight " + edge.weight);
        }
    }

}
class DisjointSet{
    int[] parent;
    int [] rank;

    DisjointSet(int v){
        parent=new int[v];
        rank=new int[v];

        for(int i=0;i<v;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    int find(int x){
        if(parent[x] != x)
            return find(parent[x]);
        else{
            return x;
        }
    }

    void union(int n1,int n2){
        if(rank[n1] > rank[n2]) {
            parent[n2]=n1;
        }
        else if(rank[n2] > rank[n1]){
            parent[n1]=n2;
        }
        else{
            parent[n1]=n2;
            rank[n2]++;
        }
    }


}

