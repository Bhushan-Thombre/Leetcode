class Solution {
    public int solve(int n1, int n2, int[] nums1, int[] nums2, int[][] memo) {
        if (n1 <= 0 || n2 <= 0) {
            return 0;
        }
        if (memo[n1][n2] != -1) {
            return memo[n1][n2];
        }

        if (nums1[n1 - 1] == nums2[n2 - 1]) {
            memo[n1][n2] = 1 + solve(n1 - 1, n2 - 1, nums1, nums2, memo);
        }else {
            memo[n1][n2] = Math.max(solve(n1 - 1, n2, nums1, nums2, memo), solve(n1, n2 - 1, nums1, nums2, memo));
        }

        return memo[n1][n2];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] memo = new int[n1 + 1][n2 + 1];

        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        return solve(n1, n2, nums1, nums2, memo);
    }
}