class Solution {
    public int balancedString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'A']++;
        }
        int n = s.length();
        int flag = 1;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (count[i] != n/4) flag = 0;
        }
        if (flag == 1) return 0;
        
        // two pointer
        // fix the left pointer
        int rets = Integer.MAX_VALUE;
        int j = 0;
        int[] subwindow = new int[26];
        for (int i = 0; i < n; i++) {
            // go the earliest right boundary
            
            while ( j < n && !isOk(subwindow, count, n) ) {
                subwindow[s.charAt(j)-'A']++;
                j++;
            }
            if (isOk(subwindow, count, n)) { // find a matched slide window
                rets = Math.min(rets, j-i);
            }
            subwindow[s.charAt(i)-'A']--;
        }
        return rets;
    }
    
    private boolean isOk(int[] sub, int[] count, int n) {
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (count[i] - sub[i] > n/4) return false;
        }
        return true;
    }
}

// binary search
// two pointer
//  W E [W Q Q E] E E
 
//  X [X X X X] X X X 
//  X X [X X] X X X X - invalid 
//  X X [X X X X] X X
