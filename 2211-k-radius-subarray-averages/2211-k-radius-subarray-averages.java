class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] avg = new int[n];
        Arrays.fill(avg, -1);

        if (2*k + 1 > n) {
            return avg;
        }

        long windowSum = 0;
        for (int i = 0; i < 2*k + 1; i++) {
            windowSum += nums[i];
        }

        avg[k] = (int)(windowSum / (2*k + 1));

        for (int i = 2*k + 1; i < n; i++) {
            windowSum = windowSum - nums[i - (2*k + 1)] + nums[i];
            avg[i - k] = (int)(windowSum / (2*k + 1));
        }

        return avg;
    }
}