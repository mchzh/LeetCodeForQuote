class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                               (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
        
        /*if (p.length() ==0) return s.length() == 0;
        if (p.length() == 1) {
            return s.length() == 1 && (s.equals(p) || p.equals("."));
        }
        if (p.charAt(1) != '*') {
            if (s.length() == 0) return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
        while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ) {
            if (isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));*/
    }
}
