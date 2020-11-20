class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[(t.charAt(i)-s.charAt(i)+26) %26]++;
        }
        int rets = 0;
        for (int i = 1; i < 26; i++) {
            if (count[i] >= 1) rets = Math.max(rets, i+(count[i]-1)*26);
        }
        return rets <= k;
    }
}

// input
// ouput
// 67000
// inabc
// oubcd
// 67111 -> 6712753
