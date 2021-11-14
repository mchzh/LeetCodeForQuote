class CombinationIterator {
    // https://dev.to/rrampage/algorithms-generating-combinations-100daysofcode-4o0a
    // http://wuchong.me/blog/2014/07/28/permutation-and-combination-realize/
    // https://leetcode.com/problems/iterator-for-combination/discuss/539184/Two-solutions-using-a-Priority-Queue-and-a-LinkedList
    // https://leetcode.com/problems/combinations/solution/
    String cur = "";
    String end = "";
    int combinationLength;
    String characters;
    int flag = 1;
    public CombinationIterator(String characters, int combinationLength) {
        cur = characters.substring(0, combinationLength);
        int len = characters.length();
        end = characters.substring(len-combinationLength, len);
        this.characters = characters;
        this.combinationLength = combinationLength;
    }
    
    public String next() {
        if (flag == 1) {
            flag = 0;
            return cur;
        }
        // find the first postiion which not in the end from right to left
        int i = combinationLength-1;
        while (i >= 0 && cur.charAt(i) == characters.charAt(i+characters.length()-combinationLength)) i--;
        
        
        // find the next of i
        int j = 0;
        while (cur.charAt(i) != characters.charAt(j)) j++;
        //System.out.println(cur + " " + i + " " + j);
        
        StringBuilder sb = new StringBuilder();
        // first part
        for (int k = 0; k < i; k++) {
            sb.append(cur.charAt(k));
        }
        // second part
        for (int k = i; k < combinationLength; k++) {
            sb.append(characters.charAt(j+1));
            j++;
        }
        
        cur = sb.toString();
        return cur;
    }
    
    public boolean hasNext() {
        //System.out.println(cur + " " + end);
        return !cur.equals(end);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// acfhx

// 3

// acf
// ach
// acx
// afh
// afx
// ahx





// fhx
