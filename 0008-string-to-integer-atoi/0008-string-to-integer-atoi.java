class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        double num = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i >= s.length()) {
            return 0;
        }
        
        boolean positive = s.charAt(i) == '+';
        boolean negative = s.charAt(i) == '-';

        if (positive || negative) {
            i++;
        }
       
        
        

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }

        num = negative ? -num : num;
        num = num > Integer.MAX_VALUE ? Integer.MAX_VALUE : num;
        num = num < Integer.MIN_VALUE ? Integer.MIN_VALUE : num;

        return (int)num;
    }
}