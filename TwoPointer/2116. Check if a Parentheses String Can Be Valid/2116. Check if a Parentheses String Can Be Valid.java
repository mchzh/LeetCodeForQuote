class Solution {
    public boolean canBeValid(String s, String locked) {
        int leftcount = 0;
        int n = s.length();
        if (n%2 == 1) return false;
        for (int i = 0; i < n; i++) {
            char l = locked.charAt(i);
            char c = s.charAt(i);
            if (l == '0' || c == '(') {
                leftcount++;
            } else if (l == '1' && c == ')') {
                if (leftcount > 0) leftcount--;
                else return false;
            }
        }
        int rightcount = 0;
        for (int i = n-1; i >= 0; i--) {
            char l = locked.charAt(i);
            char c = s.charAt(i);
            if (l == '0' || c == ')') {
                rightcount++;
            } else if (l == '1' && c == '(') {
                if (rightcount > 0) rightcount--;
                else return false;
            }
        }
        
        return true;
    }
}
