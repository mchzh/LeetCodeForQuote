class Solution {
    public List<String> generateParenthesis(int n) {
        // dfs + backtracking
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            res.add("");
            return res;
        }
        dfs(res, "", 0, 0, n);
        return res;
    }
    private void dfs(List<String> res, String str, int leftOpen, int rightOpen, int n) {
        if (leftOpen > n || rightOpen > n || rightOpen > leftOpen) return;
        if (leftOpen == n && rightOpen == n) {
            res.add(str);
            return;
        }
        
        dfs(res, str+'(', leftOpen+1, rightOpen, n);
        dfs(res, str+')', leftOpen, rightOpen+1, n);
    }
}

//                    ""
//             {                 }(X)
//     {{             {}
// {{{    {{}     {}{     {}}(X)

/*class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        combinations(res,new ArrayList<>(),0,0,n);
        return res;
    }
    
    public void combinations(List<String> res, List<Character> curr, int open, int close, int n){
        if(curr.size()== 2*n){
            StringBuilder sb = new StringBuilder();
            for(char ch: curr){
                //System.out.print(ch + " ");
                sb.append(ch);
            }
            //System.out.println(" "+ " open "+ open + " close "+ close);
            res.add(sb.toString());
            return;
        }
        
        if(open<n){
            curr.add('(');
            combinations(res,curr,open+1,close,n);
            curr.remove(curr.size()-1);
            
        }
        if(close<open){
            curr.add(')');
            combinations(res,curr,open,close+1,n);
            curr.remove(curr.size()-1);
            
        }
    }
}*/
