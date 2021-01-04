class Solution {
    class SetmentTreeNode {
        SetmentTreeNode left;
        SetmentTreeNode right;
        int start;
        int end;
        int min;
        int pos;
        public SetmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = 0;
            this.pos = 0;
            this.left = null;
            this.right = null;
        }
    }
    SetmentTreeNode root;
    
    public SetmentTreeNode buildTree(int[] target, int start, int end) {
        if (start > end) return null;
        // corner case
        SetmentTreeNode node = new SetmentTreeNode(start, end);
        if (start == end) {
            node.min = target[start];
            node.pos = start;
            return node;
        }
        
        
        int mid = start + (end - start) /2;
        node.left = buildTree(target, start, mid);
        node.right = buildTree(target, mid+1, end);
        if (node.left.min <= node.right.min) {
            node.min = node.left.min;
            node.pos = node.left.pos;
        } else {
            node.min = node.right.min;
            node.pos = node.right.pos;
        }
        
        return node;
    }
    
    public int[] queryMin(SetmentTreeNode node, int i, int j) {
        // corner case
        if (node.start == i && node.end == j) {
            return new int[] {node.min, node.pos};
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        if (j <= mid) {
            return queryMin(node.left, i, j);
        } else if (i >= mid+1) {
            return queryMin(node.right, i, j);
        } else {
            int[] left = queryMin(node.left, i, mid);
            int[] right = queryMin(node.right, mid+1, j);
            if (left[0] <= right[0]) return left;
            else return right;
        }
    }
    
    int rets = 0;
    public int minNumberOperations(int[] target) {
        root = buildTree(target, 0, target.length-1);
        dfs(0, target.length-1, 0);
        return rets;
    }
    private void dfs(int start, int end, int base) {
        // corner case
        if (start > end) {
            return;
        }
        
        int[] cur = queryMin(root, start, end);
        int minVal = cur[0];
        int minPos = cur[1];
        rets += minVal - base;
        
        dfs(start, minPos-1, minVal);
        dfs(minPos+1, end, minVal);
    }
}

// 1. segment tree to query minimun val; (recursion)
// 2. another greedy method

// pair<int, int> queryMin(start, end)  // pair include minval and minpos
