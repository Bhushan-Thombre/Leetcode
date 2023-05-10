class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'I') {
                map.put(ch, 1);
            }else if (ch == 'V') {
                map.put(ch, 5);
            }else if (ch == 'X') {
                map.put(ch, 10);
            }else if (ch == 'L') {
                map.put(ch, 50);
            }else if (ch == 'C') {
                map.put(ch, 100);
            }else if (ch == 'D') {
                map.put(ch, 500);
            }else {
                map.put(ch, 1000);
            }
        }
        int res = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            }else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}