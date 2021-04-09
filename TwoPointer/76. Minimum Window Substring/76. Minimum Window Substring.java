class Solution {
    public String minWindow(String s, String t) {
        // single count and count array
        int[] movenum = new int[256];
        for (char c : t.toCharArray()) movenum[c]++;
        int count = t.length();
        
        int right = 0, n = s.length();
        int left = 0;
        int rets = Integer.MAX_VALUE;
        String str = "";
        for (right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (movenum[c] > 0) {
                count--;
            }
            movenum[c]--;
            
            while (count == 0) {
                if (rets > right-left+1) {
                    rets = right-left+1;
                    str = s.substring(left, right+1);
                }
                if (left <= right && movenum[s.charAt(left)] >= 0) count++;
                movenum[s.charAt(left)]++;
                left++;
            }
        }
        return str;
    }
    private boolean ismatch(int[] a, int[] b) {
        for (int i = 0; i < 256; i++) {
            if (b[i] != 0 && a[i] < b[i]) return false;
        }
        return true;
    }
}
