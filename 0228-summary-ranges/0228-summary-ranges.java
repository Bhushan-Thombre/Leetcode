class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (i + 1 < nums.length && Math.abs(nums[i + 1] - nums[i]) == 1) {
                i++;
            }
            if (j == i) {
                list.add(String.valueOf(nums[i]));
            }else {
                list.add(String.valueOf(nums[j]) + "->" + String.valueOf(nums[i]));
            }
            i++;
        }
        return list;   
    }
}