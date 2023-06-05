class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int y = coordinates[1][1] - coordinates[0][1];
        int x = coordinates[1][0] - coordinates[0][0];
        for (int i = 2; i < n; i++) {
            int dy = coordinates[i][1] - coordinates[0][1];
            int dx = coordinates[i][0] - coordinates[0][0];
            if (x * dy != y * dx) {
                return false;
            }
        }
        return true;
    }
    
}