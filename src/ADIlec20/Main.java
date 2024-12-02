package ADIlec20;

public class Main {
    public static void main(String[] args) {

    }
}
class Disjointset{
    int[] parent;
    int [] rank;

    Disjointset(int v){
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

