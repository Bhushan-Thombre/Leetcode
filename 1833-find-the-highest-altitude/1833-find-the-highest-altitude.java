class Solution {
    public int largestAltitude(int[] gain) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < gain.length; i++) {
            list.add(gain[i] + list.get(i));
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }

        return max;
    }
}