class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ret;
        }
        if (p == null || p.length() == 0) {
            return ret;
        }
        if ( s.length() < p.length() ) {
            return ret;
        }
        // two pointer with map
        int[] count = new int[26];
        int plen = p.length();
        for (int i = 0; i < plen; i++) {
            count[p.charAt(i)-'a']++;
        }
        
        // k size window
        int len = s.length();
        int left = 0, right = 0;
        while (right < len) {
            char c = s.charAt(right);
            count[c-'a']--;
            if (right-left+1 == plen) {
                if (isZero(count)) ret.add(left);
            }
            while (left <= right && right-left+1 >= plen) {
                count[s.charAt(left)-'a']++;
                left++;
            }
            right++;
        }
        return ret;
    }
    private boolean isZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
