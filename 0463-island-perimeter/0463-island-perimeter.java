class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int perimeter = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Directions for moving in the grid (up, left, right, down)
        int[] rowP = {-1, 0, 0, 1};
        int[] colP = {0, -1, 1, 0};

        // Find the first land cell to start the BFS
        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    vis[i][j] = true;
                    break outerLoop;
                }
            }
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowP[i];
                int newCol = col + colP[i];

                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || grid[newRow][newCol] == 0) {
                    // If the neighbor is out of bounds or water, it contributes to the perimeter
                    perimeter++;
                } else if (!vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                    // If the neighbor is unvisited land, add it to the queue and mark as visited
                    queue.add(new int[]{newRow, newCol});
                    vis[newRow][newCol] = true;
                }
            }
        }

        return perimeter;
    }
}