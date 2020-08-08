class Solution {
    //https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
    public List<String> removeInvalidParentheses(String s) {
        // get minmun left and right number
        // isvalid
        // dfs
        // pruning
        // 1. ()) 2. first r then l, if first l, it will make prefix unvalid
        // BFS
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) { res.add(""); return res;}
        int rmvL = 0, rmvR = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                rmvL++;
            } else if (ch == ')') {
                if (rmvL == 0) {
                    rmvR++;
                } else {
                    rmvL--;
                }
            }
        }
        // dfs to check every removed parenthese
        dfs(s, 0, rmvL, rmvR, res);
        
        if (res.size() == 0) res.add("");
        return res;
    }
    public void dfs(String str, int pos, int rmvL, int rmvR, List<String> res) {
        // corner case
        if (rmvL == 0 && rmvR == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }
        
        for (int i = pos; i < str.length(); i++) {
            // pruning
            if (i > pos && str.charAt(i) == str.charAt(i-1)) continue; // consective same char
            char curc = str.charAt(i);
            if (curc == ')'  && rmvR > 0) {
                String nextString = str.substring(0, i) + str.substring(i+1);
                dfs(nextString, i, rmvL, rmvR-1, res);
            }
            if (curc == '('  && rmvL > 0) {
                String nextString = str.substring(0, i) + str.substring(i+1);
                dfs(nextString, i, rmvL-1, rmvR, res);
            }
        }
    }
    public List<String> removeInvalidParenthesesBFS(String s) {
        // get minmun left and right number
        // isvalid
        // dfs
        // pruning
        // 1. ()) 2. first r then l, if first l, it will make prefix unvalid
        // BFS
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) { res.add(""); return res;}
        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        set.add(s);
        queue.offer(s);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    found = true;
                    res.add(cur);
                    continue;
                } 
            
                // next level substring into queue
                for (int j = 0; j < cur.length(); j++) {
                    String temp = cur.substring(0, j)+cur.substring(j+1);
                    if (!set.contains(temp)) {
                        set.add(temp);
                        queue.offer(temp);
                    }    
                }
            }
            
        }
        if (res.size() == 0) res.add("");
        return res;
    }
    public boolean isValid(String str) {
        if (str == null || str.length() == 0) return false;
        int cnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                if (cnt > 0) cnt--;
                else return false;
            }
        }
        return cnt == 0;
    }
}


/*class Solution {
    public List<String> removeInvalidParentheses(String s) {
	List<String> ans = new ArrayList<>();
		remove(s,ans,0,0,new char[]{'(',')'});
    	return ans;
    }
	private static void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
		//System.out.println(" s: "+s);
		//System.out.println(" last_i: "+last_i+" s.length(): "+s.length());
		for (int stack=0,i = last_i; i < s.length(); ++i) {	//s.length()=7
			if(s.charAt(i)==par[0]) {
                stack++;
			//System.out.println(" i: "+i+" "+s.charAt(i)+": "+stack);
            }
			if(s.charAt(i)==par[1]) {
                stack--;
			//System.out.println(" i: "+i+" "+s.charAt(i)+": "+stack);
            }
			if(stack>=0) { 
                //System.out.println(" i  continue : "+i+" "+s.charAt(i)+": "+stack+" s: "+s);
                continue;
            }
			//System.out.println(" for循环之前   last_j: "+last_j);
			for (int j = last_j; j <=i; ++j) {
				//System.out.println(" j: "+j+" last_j: "+last_j+" i: "+i);
				if (s.charAt(j)==par[1]&&(j==last_j||s.charAt(j-1)!=par[1])) {
					//System.out.println(" j: "+j+" s: "+s.substring(0, j)+s.substring(j+1, s.length()));//删除了第一个 ')'  删除了第二个')'
					//System.out.println(" 递归调用 记录了 最后删除位置 的信息  删除了 : "+s.charAt(j));
					remove(s.substring(0, j)+s.substring(j+1, s.length()), ans, i, j, par);
				}
			}
			return;	
		}
		//System.out.println(" reversed之前       s: "+s);
		String reversed = new StringBuilder(s).reverse().toString();
		//System.out.println(" ans: "+ans+" reversed: "+reversed);
		if (par[0]=='(') 	// finished left to right
			{
				//System.out.println(" 反转字符串 递归调用 等于  ( ");
				remove(reversed, ans, 0, 0, new char[]{')','('});
			}
		 else 	// finished right to left
			{
			 	ans.add(reversed);
			 	//System.out.println(" 添加  : "+ans);
			}
    }
}*/
