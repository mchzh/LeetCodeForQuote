class Solution {
    public int longestAwesome(String s) {
        Map<Integer, Integer> map = new HashMap<>(); // key -> index;
        int[] count = new int[10];
        map.put(0, -1);
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c-'0']++;
            int curKey = covert2key(count);
            
            for (int j = 0; j < 10; j++) {
                int preKey = curKey^(1<<j); // only one odd
                if (map.containsKey(preKey)) ret = Math.max(ret, i-map.get(preKey));
            }
            if (map.containsKey(curKey)) {
                ret = Math.max(ret, i-map.get(curKey)); // all even
            } else {
                map.put(curKey, i);
            }
        }
        return ret;
    }
    private int covert2key(int[] count) {
        int ret = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] % 2== 1) {
                ret += (1<<i);
            }
        }
        return ret;
    }
}
// X [X X X X X] X

//    i       j
// freq [i..j] : even and only one is odd
//               1. all even : 0000000000 key = prekey
//               2. only one odd : 

// 1 2 2 3 3
// 001 : 000
