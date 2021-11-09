class Solution {
    // bitmask + map: bitmask represent word and puzzle
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> rets = new ArrayList<>();
        int n = puzzles.length;
        if (words == null || words.length == 0 || n == 0) {
            for (int i = 0; i < n; i++) rets.add(0);
        }
        
        Map<Integer, Integer> maskcount = new HashMap<>();
        // pre handle words
        for (String w : words) {
            int m = getMask(w, 0);
            //System.out.println(m);
            maskcount.put(m, maskcount.getOrDefault(m, 0) + 1);
        }
        
        // puzzle mask
        for (String p : puzzles) {
            int firstmask = (1<<(p.charAt(0)-'a'));
            int state = getMask(p, 1); // 2^6
            int count = 0;
            
            for (int subset=state; subset>=0; subset=(subset-1)&state)
            {
                
                int curmask = subset|firstmask;
                //if (curmask == 1) System.out.println(state + " " + subset + " " + firstmask);
                if (maskcount.containsKey(curmask)) count += maskcount.get(curmask);
                if (subset == 0) break;
            }
            //if (state == 52445202) break;
            rets.add(count);
        }
        return rets;
    }
    private int getMask(String s, int start) {
        int mask = 0;
        for (int i = start;i < s.length(); i++) {
            char c = s.charAt(i);
            mask |= (1<<(c-'a'));
        }
        return mask;
    }
}

//1111000111 : 26 bits -> 26 char
