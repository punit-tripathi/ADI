package ADIlec6;

public class main {
    public static void main(String[] args) {
        int [][] maze={
                {0,0,0},
                {0,1,0},
                {0,0,0}

        };
        int n= maze.length;
        int m=maze[0].length;
        System.out.println(uniquepaths(maze,0,0,n,m));
    }

    static int uniquepaths(int [][] maze,int sr,int sc,int n,int m){
        //base case
        if(sr == n-1 && sc == m-1){
            return 1;
        }
        //recursive case
        int totalpath=0;
        if(sc+1 < m && maze[sr][sc+1] != 1){
            totalpath+=uniquepaths(maze,sr,sc+1,n,m);
        }
        if(sr+1 < n && maze[sr+1][sc] != 1){
            totalpath+=uniquepaths(maze,sr+1,sc,n,m);
        }
        return totalpath;
    }
}
