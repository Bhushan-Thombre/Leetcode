class Solution {
    public long getSum(int index, int value, int n) {
        long sum = 0;

        if (index >= value) {
            sum += (long)(value + 1) * value / 2 + index - value + 1;
        }else {
            sum += (long)(value + value - index) * (index + 1) / 2;
        }

        if (value < n - index) {
            sum += (long)(value + 1) * value / 2 + n - index - value;
        }else {
            sum += (long)(value + value - n + 1 + index) * (n - index) / 2;
        }

        return sum - value;
    }
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (getSum(index, mid, n) <= maxSum) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }

        return left;       
    }
}