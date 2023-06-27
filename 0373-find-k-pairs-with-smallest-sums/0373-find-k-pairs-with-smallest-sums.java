class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        set.add(new Pair<Integer, Integer>(0, 0));

        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];

            list.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !set.contains(new Pair<Integer, Integer>(i + 1, j))) {
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                set.add(new Pair<Integer, Integer>(i + 1, j));
            }

            if (j + 1 < nums2.length && !set.contains(new Pair<Integer, Integer>(i, j + 1))) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                set.add(new Pair<Integer, Integer>(i, j + 1));
            }
            k--;
        }

        return list;
    }
}