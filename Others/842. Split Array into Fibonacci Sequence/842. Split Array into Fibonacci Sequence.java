class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        int remove = 0;
        while (remove < len && S.charAt(remove) == '0') remove++;
        if (remove == len) {
            List<Integer> zero = new ArrayList<>();
            for (int i = 0; i < len; i++) zero.add(0);
            return zero;
        } else if (remove > 1) return new ArrayList<>();
        
        
        for (int i = remove; i < Math.min(len,remove+10); i++) {
            for (int j = i+1; j< Math.min(len,i+1+10); j++) {
                List<Integer> list = new ArrayList<>();
                int cur1 = 0;
                int cur2 = 0;
                try {
                    cur1 = Integer.valueOf(S.substring(0, i+1));
                } catch(NumberFormatException e) {
                    continue;
                }
                try {
                    cur2 = Integer.valueOf(S.substring(i+1, j+1));
                } catch(NumberFormatException e) {
                    continue;
                }
                
                if (remove > 0 && cur1 != cur2) continue; 
                list.add(cur1);
                list.add(cur2);
                int curidx = j+1;
                int cur = cur1 + cur2;
                int curlen = getLen(cur);
                
                while (curidx < len && curidx+curlen <= len) {
                    int com = 0;
                    try {
                        com = Integer.valueOf(S.substring(curidx, curidx+curlen));
                    } catch(NumberFormatException e) {
                        break;
                    }
                    if (cur != com) break;
                    list.add(com);
                    cur = list.get(list.size()-2) + list.get(list.size()-1);
                    curidx = curidx+curlen;
                    curlen = getLen(cur);
                }
                if (remove > 0) list.add(0, 0);
                if (curidx == len && list.size() > 2) return list;
            }
        }
        
        return new ArrayList<>();
    }
    private int getLen(int num) {
        if (num == 0) return 0;
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
