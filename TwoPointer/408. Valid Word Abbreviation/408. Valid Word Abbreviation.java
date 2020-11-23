class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        //only lowercase and digit
        int wlen = word.length(), abbrlen = abbr.length();
        int i = 0, j = 0;
        while (i < wlen && j < abbrlen) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (!Character.isDigit(abbr.charAt(j))) {
                return false;
            } else {
                if (abbr.charAt(j) == '0') return false; // for corner case with leading zero
                int k = j;
                while (k < abbrlen && Character.isDigit(abbr.charAt(k))) k++;
                i += Integer.valueOf(abbr.substring(j, k));
                j = k;
            }
        }
        return i==wlen && j == abbrlen;
    }
}
