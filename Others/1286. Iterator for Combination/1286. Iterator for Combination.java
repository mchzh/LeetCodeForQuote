class CombinationIterator {

    String cur;
    String end;
    boolean flag;
    String characters;
    int combinationLength;
    int len;
    public CombinationIterator(String characters, int combinationLength) {
        cur = characters.substring(0, combinationLength);
        end = characters.substring(characters.length()-combinationLength);
        flag = true;
        this.characters = characters;
        this.combinationLength = combinationLength;
        len = characters.length();
    }
    
    public String next() {
        if (flag) {
            flag = false;
            return cur;
        }
        
        int i = cur.length() -1;
        while (i >= 0 && cur.charAt(i) == characters.charAt(i+len-combinationLength)) {
            i--;
        }
        // find cur i element pos which locate in characters
        int j = 0;
        while (cur.charAt(i) != characters.charAt(j)) j++;
        
        StringBuilder sb = new StringBuilder();
        sb.append(cur.substring(0, i));
        for (int k = i; k < cur.length(); k++) {
            sb.append(characters.charAt(j+1+k-i));
        }
        cur = sb.toString();
        
        return cur;
    }
    
    public boolean hasNext() {
        return !cur.equals(end);
    }
}
