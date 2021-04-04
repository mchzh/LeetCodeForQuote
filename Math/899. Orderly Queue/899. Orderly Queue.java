class Solution {
    public String orderlyQueue(String S, int K) {
        if (K >= 2) { // srot this string
            return S.chars().sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        
        String rets = S;
        for (int i = 0; i < S.length(); i++) {
            S = S.substring(1) + S.substring(0, 1);
            if (rets.compareTo(S) > 0) rets = S;
            //System.out.println(rets + " " + S + " " + rets.compareTo(S));
        }
        return rets;
    }
}
