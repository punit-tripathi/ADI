package ADIlec7;

public class Main {
    public static void main(String[] args) {
        String [][]grid={
                {".",".",".","."},
                {".",".",".","."},
                {".",".",".","."},
                {".",".",".","."}
        };
        Nqueens(grid,0);
    }
    static boolean Nqueens(String [][] grid,int row){
        //base case
        if(row == grid.length) return true;

        for(int i=0;i<grid[0].length;i++){
            if(isValid(grid,row,i)){
                grid[row][i] = "Q";
                if(Nqueens(grid,row+1)){
                    return true;
                }
                grid[row][i] = ".";
            }
        }
        return false;
    }
    static boolean isValid(String [][]grid,int row,int col){
        for(int i=row;i>=0;i--){
            if(grid[i][col] == "Q") return false;

        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(grid[i][col] == "Q") return false;
        }
        for(int i=row,j=col;i>=0 && j < grid[0].length;i--,j++){
            if(grid[i][col] == "Q") return false;
        }
        return true;
    }

}
