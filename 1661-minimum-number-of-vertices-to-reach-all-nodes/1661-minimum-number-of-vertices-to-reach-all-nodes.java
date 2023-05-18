class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList<>();
        boolean[] haveInDegree = new boolean[n];
        for (List<Integer> edge: edges) {
            haveInDegree[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!haveInDegree[i]) {
                list.add(i);
            }
        }

        return list;
    }
}