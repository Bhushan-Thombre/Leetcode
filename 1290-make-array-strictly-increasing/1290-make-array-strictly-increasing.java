class Solution {

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    private int memo(int i, int prevVal, int[] arr1, int[] arr2) {
        if (i == arr1.length) {
            return 0;
        }

        if (map.containsKey(new Pair<>(i, prevVal))) {
            return map.get(new Pair<>(i, prevVal));
        }

        int count = 2_001;

        if (arr1[i] > prevVal) {
            count = memo(i + 1, arr1[i], arr1, arr2);
        }

        int index = binarySearch(arr2, prevVal);

        if (index < arr2.length) {
            count = Math.min(count, 1 + memo(i + 1, arr2[index], arr1, arr2));
        }

        map.put(new Pair<>(i, prevVal), count);
        return count;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        int ans = memo(0, -1, arr1, arr2);

        return ans < 2_001 ? ans : -1;
    }
}