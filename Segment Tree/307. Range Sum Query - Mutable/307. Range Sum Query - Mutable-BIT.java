class NumArray {

    int[] nums;
    int[] tree;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length+1];
        for (int i = 0; i < nums.length; ++i)
            myUpdate(i, nums[i]);
    }
    
    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        myUpdate(index, delta);
    }
    public void myUpdate(int index, int val) {
        index += 1;
        for (; index < tree.length; index += (index&(-index)))
            tree[index] += val;
    }
    
    public int sum(int ind) {
        int ans = 0;
        ind += 1;
        // while (ind > 0) {
        //     ans += tree[ind];
        //     ind -= (ind&(-ind));
        // }
        for (; ind > 0; ind -= (ind&(-ind)))
            ans +=  tree[ind];
        return ans;
    }
    
    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}
