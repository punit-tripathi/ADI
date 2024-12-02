package ADIlec19;

public class Floydwarshal {
    void floydwarshall(int[][] graph,int v){
        int[][] dist=new int[v+1][v+1];

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                dist[i][j]=graph[i][j];
            }
        }

        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                       && dist[i][k]+dist[k][j] < dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }

        }
    }
}
