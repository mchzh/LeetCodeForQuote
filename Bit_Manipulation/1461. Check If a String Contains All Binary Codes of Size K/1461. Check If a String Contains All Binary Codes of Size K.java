class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int need = (1<<k);
        int comp = (1<<k)-1;
        boolean[] count = new boolean[need];
        int hasval = 0;
        for (int i = 0; i < n; i++) {
            hasval = ((hasval<<1)&comp) | (s.charAt(i)-'0');
            if (i >= k-1 && !count[hasval]) {
                count[hasval] = true;
                need--;
                if (need == 0) return true;
            }
            
        }
        return false;
    }
}
