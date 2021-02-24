class NumArray {

    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int sum;
        int start;
        int end;
        public SegmentTreeNode(int a, int b) {
            this.start = a;
            this.end = b;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
        updateTree(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return queryTree(root, i, j);
    }
    
    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        // corner case;
        if (start > end) return null;
        
        if (start == end) {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            node.sum = nums[start];
            return node;
        }
        
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        int mid = start + (end-start)/2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid+1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }
    
    public void updateTree(SegmentTreeNode node, int i, int val) {
        if (i < node.start || i > node.end) return;
        if (node == null) return;
        // corner case
        if (node.start == i && node.end == i) {
            node.sum = val;
            return;
        }
        // go left or right
        //int mid = node.start + (node.end - node.start) / 2;
        updateTree(node.left, i, val);
        updateTree(node.right, i, val);
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int queryTree(SegmentTreeNode node, int i, int j) {
        // corner case
        if (node.start == i && node.end == j) {
            return node.sum;
        }
        
        // three range: [start, mid] [mid+1, end] [i, j]
        int mid = node.start + (node.end - node.start) / 2;
        if (j <= mid) {
            return queryTree(node.left, i, j);
        } else if (i >= mid+1) {
            return queryTree(node.right, i, j);
        } else {
            return queryTree(node.left, i, mid) + queryTree(node.right, mid+1, j);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

// segment tree

// update [3]

//           [0-7]
//     [0-3]       [4,5]
// [0-1]  [2-3]    4, 5
// 0, 1   2, 3 
    
    
    
//     complete tree last level is N, second last level is N/2
//     1
//     2
//     .
//     .
//     N/4
//     N/2
//     N
//     update O(lgN)
//     query  O(lgN)

    // [0,9,5,7,3]
    // 0,9,5  7,3-> 10
    //        7 3


// BIT
/*class NumArray {

    int[] tree;
    int[] nums;
    int size;
    public NumArray(int[] nums) {
        this.size = nums.length;
        this.nums = new int[size];
        this.tree = new int[size];
        for (int i = 0; i < size; ++i)
            update(i, nums[i]);
    }
    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        for (; i < size; i |= i + 1)
            tree[i] += delta;
    }
    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
    public int sum(int ind) {
        int ans = 0;
        while (ind >= 0) {
            ans += tree[ind];
            ind &= ind + 1;
            ind--;
        }
        return ans;
    }
}*/ 
