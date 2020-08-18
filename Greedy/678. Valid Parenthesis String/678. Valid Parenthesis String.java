class Solution {
    // https://leetcode.com/problems/valid-parenthesis-string/discuss/107572/Java-using-2-stacks.-O(n)-space-and-time-complexity.
    public boolean checkValidString(String s) {
        //int count = 0;
        int countMax = 0;
        // unmatched # of left parenthesis, if "*" try "(" as many as possible
        int countMin = 0;
        // unmatched # of left parenthesis, if "*" try ")" as many as possible
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                countMax++;
                countMin++;
            } else if (c == ')') {
                countMax--;
                countMin--;
            } else {
                countMax++;
                countMin--;
            }
            if (countMax < 0) return false;
            if (countMin < 0) countMin = 0;
        }
        return countMin == 0;
    }
}
// [countMax, countMin]
// ((((***))))
