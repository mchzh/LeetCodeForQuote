class Solution {
    public int maxSumMinProduct(int[] nums) {
        long mod = (long)(1e9+7);
        int n = nums.length;
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        
        int[] left = new int[n];
        Stack<Integer> stack1 = new Stack<>(); // mono increasing to find the first smaller element for current element
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && nums[stack1.peek()] >= nums[i]) stack1.pop();
            if (stack1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack1.peek();
            }
            stack1.push(i);
        }
        int[] right = new int[n];
        Stack<Integer> stack2 = new Stack<>(); // mono increasing to find the right first smaller element for current element
        for (int i = n-1; i >= 0; i--) {
            while (!stack2.isEmpty() && nums[stack2.peek()] >= nums[i]) stack2.pop();
            if (stack2.isEmpty()) {
                right[i] = -1;
            } else {
                right[i] = stack2.peek();
            }
            stack2.push(i);
        }
        
        // left and right boundary
        long rets = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i] == -1 ? 0 : left[i]+1;
            int r = right[i] == -1 ? n-1 : right[i]-1;
            
            long cursum = sum[r+1]-sum[l];
            //System.out.println(l + " " + r + " " + i + " " + cursum);
            rets = Math.max(rets, (long)nums[i]*cursum);
        }
        return (int)(rets%mod);
    }
}
