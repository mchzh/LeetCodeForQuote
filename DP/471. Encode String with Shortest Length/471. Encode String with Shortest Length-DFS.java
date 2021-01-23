class Solution {
    // dfs + memo => dp
    Map<String, String> map = new HashMap<>();
    public String encode(String s) {
        // base case
        if (s == null || s.length() == 0) return s;
        if (s.length() <= 4) return s;
        if (map.containsKey(s)) return map.get(s);
        
        String rets = s;
        // count repeat string from right to left
        for (int k = s.length()/2; k < s.length(); k++) {
            String pattern = s.substring(k);
            int times = countRepeat(s, pattern);
            //System.out.println(k + " " + times + " " + pattern + " " + s);
            if (times*pattern.length() != s.length()) continue;
            
            String candidates = Integer.toString(times) + "[" + encode(pattern) + "]";
            if (rets.length() >= candidates.length()) rets = candidates;
        }
        
        // divide as two part to do the same logic: left and right
        for (int i = 1; i < s.length(); i++) {
            String left = encode(s.substring(0, i));
            String right = encode(s.substring(i));
            String candidates = left + right;
            if (rets.length() >= candidates.length()) rets = candidates;
        }
        
        map.put(s, rets);
        return rets;
    }
    private int countRepeat(String s, String p) {
        String start = p;
        int times = 0;
        int idx = 0;
        while (start.length() < s.length() && start.equals(s.substring(0, (times+1)*p.length()))) {
            times++;
            start = start+p;            
        }
        if (start.equals(s)) times++;
        return times;
    }
}
