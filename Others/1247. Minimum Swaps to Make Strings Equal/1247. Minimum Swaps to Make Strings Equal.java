class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        
        int countx = 0, county = 0;
        for (char c : s1.toCharArray()) {
            if (c == 'x') countx++;
            else county++;
        }
        for (char c : s2.toCharArray()) {
            if (c == 'x') countx++;
            else county++;
        }
        if (countx%2 != 0 || county %2 != 0) return -1;
        
        int n = s1.length();
        int rets = 0;
        countx = 0;
        county = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 == c2) continue;
            if (c1 == 'x') countx++;
            else county++;
        }

        rets += countx/2;   
        rets += county/2;
        if (countx%2 != 0) rets += 2;
        return rets;
    }
}
