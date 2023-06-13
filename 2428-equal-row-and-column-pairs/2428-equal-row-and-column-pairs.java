class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        Map<String, Integer> row = new HashMap<>();
        for (int[] arr: grid) {
            String rowString = Arrays.toString(arr);
            row.put(rowString, row.getOrDefault(rowString, 0) + 1);
        }

        for (int col = 0; col < n; col++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; r++) {
                colArray[r] = grid[r][col];
            }

            count += row.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}