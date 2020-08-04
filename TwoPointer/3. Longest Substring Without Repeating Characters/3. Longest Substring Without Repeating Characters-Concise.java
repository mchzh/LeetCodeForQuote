class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null && s.length() == 0) return 0;
        // two pointer
        int[] chars = new int[256];
        Arrays.fill(chars, -1);
        int left = 0, right = 0;
        int max = 0;
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (chars[ch] != -1) {
                left = Math.max(left, (chars[ch]+1) );
            }
            chars[ch] = right;
            max = Math.max(max, right-left+1);  
        }

        return max;
    }
}
