package ADIlec17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}
class Graph{
    int V;
    List<Integer>[] adjlist;

    public Graph(int V){
        this.V=V;
        adjlist=new List[V+1];
        for(int i=0;i<=V;i++){
            adjlist[i]=new ArrayList<>();
        }
    }

    int add(int v1,int v2){
        adjlist[v1].add(v2);
        return v2;
    }
    void BFS(int startVertex){
        boolean[] vis=new boolean[V+1];
        Queue<Integer>q=new LinkedList<>();
        vis[startVertex]=true;
        q.add(startVertex);

        while (!q.isEmpty()){
            int vertex=q.poll();
            System.out.println(vertex);
            for(int ele:adjlist[vertex]){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }

    void DFS(int startVertex){
        boolean[] vis=new boolean[V+1];
        DFShelper(startVertex,vis);
    }
    void DFShelper(int startVertex,boolean[] vis){
        vis[startVertex]=true;
        System.out.println(startVertex);

        for(int ele:adjlist[startVertex]){
            if(!vis[startVertex]){
                DFShelper(ele,vis);
            }
        }
    }
}
