class Solution {
    // https://medium.com/@rebeccahezhang/leetcode-418-sentence-screen-fitting-9d6258ce116e
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int r = 0;
        int l = 0;
        int idx = 0;
        int rets = 0;
        while (r < rows && idx < n) {
            int len = sentence[idx].length();
            if (cols-l>= len) {
                l += len;
                idx++;
                if (l != cols) l++;
            } else {
                r++;
                l = 0;
                
            }
            //System.out.println(r + " " + l + " " + idx);
            if (idx == n) {
                rets++;
                idx = 0;
            }
        }
        return rets;
    }
    public int wordsTypingEx(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int r = 0;
        int l = 0;
        int rets = 0;
        while (r < rows) {
            int idx = 0;   
            for (idx = 0; idx < n; idx++) {
                if (r >= rows) break;
                int len = sentence[idx].length();
                if (cols-l>= len) {
                    l += len;
                    if (l != cols) l++;
                } else {
                    r++;
                    l = 0;
                    idx--;
                }
            }
            //System.out.println(r + " " + l + " " + idx);
            if (idx == n) rets++;
        }
        return rets;
    }
}
