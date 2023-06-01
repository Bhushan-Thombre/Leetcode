class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});

        for  (int count = 1; !queue.isEmpty(); count++) {
            for (int i = queue.size(); i > 0; i--) {
                int[] currCell = queue.poll();

                if (currCell[0] == n - 1 && currCell[1] == n - 1) {
                    return count;
                }

                for (int[] move : moves) {
                    int x = currCell[0] + move[0];
                    int y = currCell[1] + move[1];

                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }

        return -1;
    }
}