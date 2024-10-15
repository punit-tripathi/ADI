package ADIlec6;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int [][] maze={
                {1,0,0,0},
                {1,1,0,0},
                {1,1,0,0},
                {0,1,1,1}
        };
        int [][] visited={
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        ArrayList<String>res=new ArrayList<>();
        int n= maze.length;
        int m=maze[0].length;

        helper(maze,visited,0,0,n,m,res,"");
    }
    static void helper(int [][]maze,int [][]visited,int sr,int sc,int n,int m,ArrayList<String>res,String path){
        //base case
        if(sr == n-1 && sc == m-1){
            res.add(path);
            return;
        }
        //recursive case
        maze[sr][sc] = -1;

        if(sc+1 < m && maze[sr][sc+1] == 1 && visited[sr][sc+1] != 1){
            helper(maze,visited,sr,sc+1,n,m,res,path+"R");
        }
        if(sc-1 >= 0 && maze[sr][sc-1] == 1 && visited[sr][sc-1] != 1){
            helper(maze,visited,sr,sc-1,n,m,res,path+"L");
        }
        if(sr+1 < n && maze[sr+1][sc] == 1 && visited[sr+1][sc] != 1){
            helper(maze,visited,sr+1,sc,n,m,res,path+"D");
        }
        if(sr-1 >= 0 && maze[sr-1][sc] == 1 && visited[sr-1][sc] != 1){
            helper(maze,visited,sr-1,sc,n,m,res,path+"U");
        }
        maze[sr][sc]=1;
    }
}
