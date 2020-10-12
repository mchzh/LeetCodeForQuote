class Solution {
    // two point
    public int equalSubstring(String s, String t, int maxCost) {
        if ( s == null || s.length() == 0 || s.length() != t.length() ) return 0;
        int left = 0, right = 0;
        int N = s.length();
        int max = 0;
        
        int cost = 0;
        for (int j = 0; j < N; j++) {
            char sc = s.charAt(j);
            char tc = t.charAt(j);
            if (sc != tc) {
                cost += Math.abs(sc - tc);
            }
            if (cost <= maxCost) {
                max = Math.max(max, j-left+1);
            }
            while (left <= j && cost > maxCost) { // consider "=" condition
                char lsc = s.charAt(left);
                char ltc = t.charAt(left);
                if (lsc != ltc) cost -= Math.abs(lsc - ltc);
                left++;
            }
        }
        return max;
    }
}
// "anryddgaqpjdw"
// "zjhotgdlmadcf"
// 5
// one letter change has the maxCost need to consider left == j
