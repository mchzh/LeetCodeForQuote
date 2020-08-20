class Solution {
    // https://leetcode.com/problems/strings-differ-by-one-character/discuss/801805/JAVA-O(26*N*M)-Using-Hash
    static long mod = 1_000_000_0007l;
    public boolean differByOne(String[] dict) {
        int N = dict.length, M = dict[0].length();
        Set<Long> set = new HashSet<>();
        long[] h = new long[N];
        // get hash array
        for (int i = 0; i < N; i++) {
            long hash = 0;
            for (int j = 0; j < M; j++) {
                hash = (hash*26 + (dict[i].charAt(j)-'a')) % mod;
            }
            h[i] = hash;
            set.add(h[i]);
        }
        
        // power val
        long[] power = new long[M];
        power[0] = 1;
        for (int i = 1; i < M; i++) {
            power[i] = (power[i-1] * 26l) % mod;
        }
        
        // loop to compare the different single char
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                long hWithoutJ = ( h[i] - ((dict[i].charAt(j)-'a')*power[M-j-1]) ) % mod;
                // long hWithoutJ = ((h - (dict[i].charAt(j)-'a')*power[m-j-1])%mod+mod)%mod;
                for (int k = 0; k < 26; k++) {
                    if ( k == (dict[i].charAt(j)-'a') ) continue;
                    long hWithK = (hWithoutJ + k*power[M-j-1]) % mod;
                    if ( set.contains(hWithK) ) return true;
                }
            }
        }
        return false;
    }
    public boolean differByOneBurteForce(String[] dict) {
        for (int i = 0; i < dict.length; i++) {
            for (int j = i+1; j < dict.length; j++) {
                if (isDiff(dict[i], dict[j])) return true;
            }
        }
        return false;
    }
    private boolean isDiff(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) continue;
            count++;
        }
        return count == 1;
    }
}
