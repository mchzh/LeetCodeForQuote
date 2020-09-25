class Solution {
    // brute-force : two loop
    // reduce time complexity
    // hashmap save the current count of vowel until the current position
    // prefix
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>(); // key -> index
        map.put(0, -1);
        int[] count = new int[5]; 
            
        int ret = 0;
        for (int i= 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                count[0] += 1;
            else if (c == 'e')
                count[1] += 1;
            else if (c == 'i')
                count[2] += 1;
            else if (c == 'o')
                count[3] += 1;
            else if (c == 'u')
                count[4] += 1;
            
            int key = convert2key(count);
            if (map.containsKey(key)) {
                ret = Math.max(ret, i-map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return ret;
    }
    private int convert2key(int[] count) {
        int ret = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2== 1) {
                ret += (1<<i);
            }
        }
        return ret; // e odd : 00010
    }
}

// subtring subarray 
// prefix

// X X [X X X X] X
//      ^     ^
//      i     j

// hash + prefix + state compression

// freq[i--j] = freq[1--j] - freq[1--i]
//                 odd           odd
//                 even          even
//                00000          00000
//                01010          01010
    
// 00000 -> key longest
// Map[key] -> index;

//  aaee -> 00
//     j  -> 3-(-1) = 4
// map[0] = -1;
