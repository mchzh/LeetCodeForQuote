class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if ( i+1 < s.length() && s.charAt(i+1)==')' ) {
                    i++;
                } else {
                    ret++;
                }
                count--;
            }
            if (count < 0) {
                ret++;
                count = 0;
            }
        }
        ret += count * 2;
        return ret;
    }
}

// Greedy: # represent unmatched ( num, if count < 0, handle ')' 
// Stack: '(' push stack, ')' pop stack
// Greedy: count - unmatched left parethese
// 1. must two consective ) cancel one (;
// 2. at the end, ret += count*2;
