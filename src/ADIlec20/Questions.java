package ADIlec20;

public class Questions {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If the source cell already has the same value as `color`, return the
        // original
        // image
        if (image[sr][sc] == color) {
            return image;
        }

        // Storing the original value of the starting cell
        int oldColor = image[sr][sc];
        // Replacing the value of the starting cell with the specified color
        image[sr][sc] = color;

        // Calling the dfs function to replace the values of all connected cells
        dfs(image, sr, sc, oldColor, color);

        // Return the modified image
        return image;
    }

    private void dfs(int[][] grid, int row, int col, int oldTarget, int newTarget) {
        // Defining the four cells adjacent to the starting cell
        int[][] adjacentCells = {
                { 0, 1 }, // move right
                { 1, 0 }, // move down
                { -1, 0 }, // move up
                { 0, -1 } // move left
        };

        // Get the dimensions of the grid
        int gridLength = grid.length;
        int totalCells = grid[0].length;

        // For each cell in the list of adjacent cells
        for (int[] cellValue : adjacentCells) {
            int r = row + cellValue[0];
            int c = col + cellValue[1];

            // If the adjacent cell is within the bounds of the grid
            // and has the same value as the starting cell
            if (r < gridLength && r >= 0 && c < totalCells && c >= 0 && grid[r][c] == oldTarget) {
                // Replace the value of the adjacent cell with the specified
                // target
                grid[r][c] = newTarget;
                // Recursively call the dfs function on the adjacent cell
                dfs(grid, r, c, oldTarget, newTarget);
            }
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // Step 1: Enqueue all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int count = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: BFS to rot fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] dir : directions) {
                    int nx = row + dir[0];
                    int ny = col + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && !visited[nx][ny] && grid[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        grid[nx][ny] = 2;  // Rot the fresh orange
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // Step 3: Check for remaining fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;  // Fresh orange remains
                }
            }
        }

        return count == -1 ? 0 : count;  // Return time or 0 if no fresh oranges
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        currentPath.add(0);
        int length=graph.length;
        recSol(res,0,length-1,graph,currentPath);
        return res;
    }
    public void recSol(List<List<Integer>> resList,int currentNode,int destinationNode,int[][] graph ,List<Integer> currentPath ){

        // System.out.println(" currentNode : " + currentNode + " destinationNode : " + destinationNode);
        if(currentNode == destinationNode){

            List<Integer> finalPath=new ArrayList<>();
            finalPath.addAll(currentPath);
            // finalPath.add(destinationNode);

            resList.add(finalPath);
            // System.out.println(" reached destination : " + finalPath);


        }else{
            // currentPath.add(currentNode);
            // System.out.println(" currentPath : " + currentPath);
            int[] childNode=graph[currentNode];
            for(int temp:childNode){
                currentPath.add(temp);
                recSol(resList,temp,destinationNode,graph,currentPath);
                currentPath.remove(currentPath.size()-1);
            }
        }
    }
}
