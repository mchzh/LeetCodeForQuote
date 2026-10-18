class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    long mod = (long)(1e9+7);

    long[][] comb = new long[1001][1001];
    public long getComb(int m, int n) {
        if (comb[m][n] != 0L) {
            return comb[m][n];
        }
        // C(5,2) =C(5,3)
        if (n > m-n) {
            return getComb(m, m-n);
        }

        if (n == 0L) {
            return 1L;
        }
        if (n == 1L) {
            return m;
        }

        long a = getComb(m-1, n);
        long b = getComb(m-1, n-1);
        comb[m][n] = (a + b)%mod;
        return comb[m][n];
    }

    public int numOfWays(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertNode(root, nums[i]);
        }

        return (int)((dfs(root)[0] - 1 + mod) % mod); // maybe negative
    }

    private void insertNode(TreeNode node, int a) {
        // All integers in nums are distinct.
        if (a < node.val) {
            // left 
            if (node.left == null) {
                node.left = new TreeNode(a);
            } else {
                insertNode(node.left, a);
            }
        } else {
            // right 
            if (node.right == null) {
                node.right = new TreeNode(a);
            } else {
                insertNode(node.right, a);
            }
        }
    }

    private long[] dfs(TreeNode node) {
        if (node == null) {
            return new long[]{1,0};
        }
        if (node.left == null && node.right == null) {
            return new long[] {1,1};
        }
        // long[] left = new long[2];
        // long[] right = new long[2];
        // if (node.left != null) {
        //    left = dfs(node.left);  
        // }
        // if (node.right != null) {
        //     right = dfs(node.right);
        // }
        long[] left = dfs(node.left);
        long[] right = dfs(node.right);
        long lseq = left[0], lnum = left[1];
        long rseq = right[0], rnum = right[1];
        
        //long seqNum = ((lseq%mod) * (rseq%mod) * (getComb((int)(lnum + rnum),(int)(lnum))%mod))%mod;
        long ways = getComb((int)(lnum + rnum), (int)lnum);

long seqNum = (lseq * rseq) % mod;
seqNum = (seqNum * ways) % mod;
        long nodeNum = lnum + rnum + 1L;
        return new long[] {seqNum, nodeNum};
    }
}

// root : 3
// [1, 2]
// [4, 5]
// [.......]m
// [.......]n
// [..x.x....xxx..xx.]m+n => C(m+n, n)
// seqNum = L*R*comb(m+n, m)
//        = lseq*rseq*C(lnoden+rnoden, lnoden)

// C(a, b) = C(a-1, b) + (a-1, b-1)
