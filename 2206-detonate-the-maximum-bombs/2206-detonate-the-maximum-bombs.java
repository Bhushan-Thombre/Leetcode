class Solution {

    public int dfs(int curr, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        visited.add(curr);
        int count = 1;
        for (int neighbor : map.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                count += dfs(neighbor, visited, map);
            }
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int r1 = bombs[i][2];
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];

                if ((long) Math.pow(r1, 2) >= (long) Math.pow(x1 - x2, 2) + (long) Math.pow(y1 - y2, 2)) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), map);
            answer = Math.max(answer, count);
        }

        return answer;
    }
}