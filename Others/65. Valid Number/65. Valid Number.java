class Solution {
    // [+/- .] e[+/- ] use e divide as two part
    public boolean isNumber(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        while (left < n && s.charAt(left) == ' ') left++;
        while (right >= left && s.charAt(right) == ' ') right--;
        if (left > right) return false;
        String cur = s.substring(left, right+1); // remove the front and rear spcace
        
        // get e count
        int counte = 0;
        int posE = -1;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == 'e' || cur.charAt(i) == 'E') {
                counte++;
                posE = i;
            }
        }
        if (counte > 1) return false;
        else if (counte == 0) return isOk(cur, 1);
        else return isOk(cur.substring(0, posE), 1) && isOk(cur.substring(posE+1), 0); // left and right of E
    }
    private boolean isOk(String str, int k) {
        // sign
        if (str == null || str.length() == 0) return false;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if ( (c == '+' || c == '-') && i != 0 ) return false;
        }
        if (str.charAt(0) == '+' || str.charAt(0) == '-') str = str.substring(1);
        if (str == null || str.length() == 0) return false;
        if (str.length() == 1 && str.charAt(0) =='.') return false;
        int countdot = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') countdot++;
            else {
                if (!Character.isDigit(str.charAt(i))) return false;
            }
        }
        return countdot <= k;
    }
}
