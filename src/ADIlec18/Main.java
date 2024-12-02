package ADIlec18;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g1=new Graph(6);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(4,2);
        g1.addEdge(5,2);
        g1.addEdge(3,5);
        g1.addEdge(6,4);
    }
}

 class Graph{
    int v;
    List<Integer>[] adjlist;

    Graph(int v) {
        this.v = v;
        adjlist = new List[v + 1];
        for (int i = 0; i <= v; i++) {
            adjlist[i] = new ArrayList<>();
        }
    }
        void addEdge(int v1,int v2){
            adjlist[v1].add(v2);
            adjlist[v2].add(v1);
        }

        boolean isCycle(){
        boolean[] vis=new boolean[v+1];

        for(int i=0;i <= v;i++){
            if(!vis[i]){
                if(isCycleUtil(i,vis,-1)) return true;
            }
        }
        return false;
    }
    boolean isCycleUtil(int v,boolean[] vis,int parent){
        vis[v]=true;
        for(int ele:adjlist[v]){
            if(!vis[ele]){
                isCycleUtil(ele,vis,v);
            }
            else if(parent != ele){
                return true;
            }
        }
        return false;
    }

    int minEdge(int src,int dest){
        boolean[] vis=new boolean[v+1];
        vis[src]=true;
        int[] dist=new int[v+1];
        Arrays.fill(dist,-1);
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        dist[src]=0;

        while(!q.isEmpty()){
            int temp=q.poll();
            for(int ele:adjlist[temp]){
                if(!vis[ele]){
                    vis[ele]=true;
                    dist[ele]=dist[temp]+1;
                    q.add(ele);
                    if(ele == dest) return dist[ele];
                }

            }
        }
        return -1;
    }
}
class DirGraph{
    int v;
    List<Integer>[] adjlist;

    DirGraph(int v) {
        this.v = v;
        adjlist = new List[v + 1];
        for (int i = 0; i <= v; i++) {
            adjlist[i] = new ArrayList<>();
        }
    }

    void addEdge(int v1,int v2){
        adjlist[v1].add(v2);
    }

    boolean isCycle(){
        boolean[] vis=new boolean[v+1];
        boolean[] currpath=new boolean[v+1];

        for(int i=0; i<=v;i++){
            if(!vis[i]){
                if(isCycleutil(i,vis,currpath)) return true;
            }
        }
        return false;
    }

    boolean isCycleutil(int v,boolean[] vis,boolean[] currpath){
        vis[v]=true;
        currpath[v]=true;

        for(int ele:adjlist[v]){
            if(!vis[ele]){
                isCycleutil(ele,vis,currpath);
            }
            else if(currpath[ele]){
                return true;
            }
        }
        currpath[v]=false;
        return false;
    }
     boolean isPath(int src,int dest){
        boolean[] vis=new boolean[v+1];
       if(isPathUtil(src,dest,vis)) return true;
        return false;
     }
     boolean isPathUtil(int src,int dest,boolean[] vis){
        if(src == dest) return true;
        vis[src]=true;

        for(int ele:adjlist[src]){
            if(!vis[ele]){
                if(isPathUtil(ele,dest,vis)) return true;
            }
        }
        return false;
     }

}




