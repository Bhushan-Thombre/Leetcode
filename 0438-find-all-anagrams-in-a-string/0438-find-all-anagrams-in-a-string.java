class Solution {
    public boolean isAnagram(String str, String pat, int i) {
        int[] alphabet = new int[26];
        
        for (int j = 0; j < pat.length(); j++) {
            alphabet[pat.charAt(j) - 'a']++;
            alphabet[str.charAt(i + j) - 'a']--;
        }

        for (int k = 0; k < alphabet.length; k++) {
            if (alphabet[k] != 0) {
                return false;
            }
        }

        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(s, p, i)) {
                list.add(i);
            }
        }

        return list;
    }
}