package ADIlec7;

public class sudokuSolve {
    public static void main(String[] args) {
        int[][] grid =
                {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        soduku(grid,0,0);
    }
    static boolean soduku(int [][]grid,int row,int col){
        //base case
        if(row == grid.length && col == grid[0].length) return true;
        if(col == grid[0].length){
            row++;
            col=0;
        }

        if(grid[row][col] != 0) return soduku(grid,row,col+1);
        //recursive case
        for(int i=1;i<=9;i++){
            if(isValid(grid,row,col,i)){
                grid[row][col] = i;
                if(soduku(grid,row,col+1))return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }
   static boolean isValid(int [][]grid,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(grid[i][col] == num || grid[row][i] == num) return false;
        }
        int sr=row - (row % 3);
        int sc=col - (col % 3);
        for(int i=sr;i< sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(grid[i][j] == num) return false;
            }
        }
        return true;
   }

}
