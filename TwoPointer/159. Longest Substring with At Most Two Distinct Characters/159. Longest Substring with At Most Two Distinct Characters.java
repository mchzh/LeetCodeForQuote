class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int N = s.length(), ret = 0;
        int left = 0, right = 0;
        int[] set = new int[256];
        int distinct = 0;
        for (; right < N; right++) {
            char ch = s.charAt(right);
            set[ch]++;
            if (set[ch] == 1) distinct++;
            if (distinct <= 2) {
                ret = Math.max(ret, right-left+1);
            } else {
                while (left < right && distinct > 2) {
                    set[s.charAt(left)]--;
                    if (set[s.charAt(left)] == 0) distinct--;
                    left++;
                }
            }
        }
        return ret;
    }
    private int getDistinctChar(int[] set) {
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (set[i] != 0) count++;
        }
        return count;
    }

}
