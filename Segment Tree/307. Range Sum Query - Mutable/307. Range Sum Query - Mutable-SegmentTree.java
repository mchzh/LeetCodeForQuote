class NumArray {
    // segment tree

    class SegTreeNode {
        SegTreeNode left;
        SegTreeNode right;
        int val;
        int start, end;
        public SegTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.val = 0;
            this.left = null;
            this.right = null;
        }
    }
    int[] nums;
    SegTreeNode root;
    // three function : init(), getrange(), updateval()
    private void init(SegTreeNode node, int start, int end) {
        if (start > end) return;
        if (start == end) {
            node.val = nums[start];
            return;
        }
        int mid = start + (end-start)/2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid+1, end);
        }
        init(node.left, start, mid);
        init(node.right, mid+1, end);
        node.val = node.left.val + node.right.val;
    }
    private int range(SegTreeNode node, int left, int right) {
        if (right < node.start || left > node.end) {
            return 0; // write your logic
        }
        if (left <= node.start && right >= node.end) {
            return node.val;
        }
        return range(node.left, left, right) + range(node.right, left, right);
    }
    private void updateSingle(SegTreeNode node, int index, int val) {
        if (index < node.start || index > node.end) return;
        if (node.start == node.end) {
            node.val = val;
            return;
        }
        updateSingle(node.left, index, val);
        updateSingle(node.right, index, val);
        node.val = node.left.val + node.right.val;
    }
    
    public NumArray(int[] nums) {
        this.nums = nums;
        root = new SegTreeNode(0, nums.length-1);
        init(root, 0, nums.length-1);
    }
    
    public void update(int index, int val) {
        updateSingle(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return range(root, left, right);
    }
}
