class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null && s.length() == 0) return 0;
        // two pointer
        Map<Character, Integer> map = new HashMap<>();
        int N = s.length();
        int left = 0, right = 0;
        int max = 0;
        for (; right < N; right++) {
            char ch = s.charAt(right);
            // set
            if (map.containsKey(ch)) {
                int moveidx = map.get(ch)+1;
                while (left < right && left < moveidx) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            
            map.put(ch, right);
            max = Math.max(max, right-left+1);  
        }
//         while (right < N) {
//             char ch = s.charAt(right);
//             // set
//             if (map.containsKey(ch)) {
//                 int moveidx = map.get(ch)+1;
//                 while (left < moveidx) {
//                     map.remove(s.charAt(left));
//                     left++;
//                 }
//             }
            
//             map.put(ch, right);
//             max = Math.max(max, right-left+1);
//             right++;
//         }
        //max = Math.max(max, right-left);
        return max;
    }
}
//left right pointer
// xxx uni right++
// no uni left++
// update maxlen
