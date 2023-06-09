class Solution {
    public int maxIndex(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums[max]) {
                max = i;
            }
        }
        return max;
    }
    public int dominantIndex(int[] nums) {
        int largestIndex = maxIndex(nums);

        Arrays.sort(nums);
        if (nums[nums.length - 1] >= 2 * nums[nums.length - 2]) {
            return largestIndex;
        }

        return -1;
    }
}