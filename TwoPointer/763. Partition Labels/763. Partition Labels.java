class Solution {
//     traverse the string record the last index of each char.
// using pointer to record end of the current sub string.
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        int N = S.length();
        // Greedy
        int[] charIdx = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            charIdx[c-'a'] = i;
        }
        int rangeidx = 0;
        int left = -1, right = 0;
        while (right < N) {
            char cur = S.charAt(right);
            int lastIdx = charIdx[cur-'a'];
            //System.out.println("current visite char -> " + cur + " : pos -> " +charIdx[cur-'a']);
            rangeidx = Math.max(rangeidx, lastIdx);
            if (right == rangeidx) {
                ret.add(right-left);
                left = right;
            }
            right++;
        }
        return ret;
//         List<Integer> ret = new ArrayList<>();
//         if (S == null || S.length() == 0) return ret;
//         int[] map = new int[26];
//         for (int i = 0; i < S.length(); i++) {
//             map[S.charAt(i)-'a'] = i;
//         }
        
//         int last = 0;
//         int start = 0;
//         for (int i = 0; i < S.length(); i++) {
//             last = Math.max(last, map[S.charAt(i)-'a']);
//             if (last == i) {
//                 ret.add(last-start+1);
//                 start = last+1;
//             }
//         }
//         return ret;
    }
}

/*class Solution {
    public List<Integer> partitionLabels(String S) {
        // record the last postion for this char
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            int curend = last[S.charAt(i)-'a'];
            if (curend > end) {
                end = curend;
            }
            if (i == end) {
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }
}*/
