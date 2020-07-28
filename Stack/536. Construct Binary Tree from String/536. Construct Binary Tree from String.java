/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // stack -> iterative
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        return dfs(s, 0, s.length()-1);
    }
    private TreeNode dfs(String s, int left, int right) {
        if (left > right) return null;
        // get root number
        int sign = 1;
        if (s.charAt(left) == '-') {
            left++;
            sign = -1;
        }
        int num = 0;
        while (left <= right && (s.charAt(left)>='0' && s.charAt(left)<='9') ) {
            num = num *10 + (s.charAt(left)-'0');
            left++;
        }
        
        TreeNode root = new TreeNode(sign*num);
        if (left >= right) {
            return root;
        }

        // locate to the left sub tree
        int leftopen = 0;
        int midIdx = 0;
        for (int i = left; i <= right; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftopen++;
            } else if (ch == ')') {
                leftopen--;
                if (leftopen == 0) {
                    midIdx = i;
                    break;
                }
            }
        }
        
        root.left = dfs(s, left+1, midIdx-1);
        root.right = dfs(s, midIdx+2, right-1);
        return root;
    }
}

/*class Solution {
    public TreeNode str2tree(String s) {
        
        if(s==null || s.isEmpty())
          return null;
        
        Stack<TreeNode> st=new Stack<>();

        
        for(int i=0;i<s.length();i++)
        {
            int j=i;
            char c=s.charAt(i);
            if(c==')')
                st.pop();
            else if(Character.isDigit(c) || c=='-')
            {
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1)))
                {
                    i++;
                }
              int  n=Integer.parseInt(s.substring(j,i+1));
         
                TreeNode current=new TreeNode(n);
                if(!st.isEmpty())
                {
                TreeNode parent=st.peek();
                if(parent.left!=null)
                    parent.right=current;
                else
                    parent.left=current;
                }
                
                st.push(current);
            }
        }
        
        return st.isEmpty()?null:st.pop();
    }
}*/
