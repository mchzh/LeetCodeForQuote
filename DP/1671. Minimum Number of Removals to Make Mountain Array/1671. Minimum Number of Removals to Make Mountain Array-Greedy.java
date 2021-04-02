class Solution {
    // opposite direction
    // get two direction lis and compaer left and right remove number
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftlis = new int[n];
        int[] rightlis = new int[n];
        
        List<Integer> left = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            if (left.size() == 0 || nums[i] > left.get(left.size()-1)) {
                left.add(nums[i]);
            } else {
                int pos = Collections.binarySearch(left, nums[i]);
                if (pos < 0) left.set(-1*(pos+1), nums[i]);
            }
            leftlis[i] = left.size();
        }
        List<Integer> right = new ArrayList<>();
        for (int i = n-1; i >= 0 ; i--) {
            if (right.size() == 0 || nums[i] > right.get(right.size()-1)) {
                right.add(nums[i]);
            } else {
                int pos = Collections.binarySearch(right, nums[i]);
                if (pos < 0) right.set(-1*(pos+1), nums[i]);
            }
            rightlis[i] = right.size();
        }
        int rets = Integer.MAX_VALUE;
        for (int i = 1; i < n-1 ; i++) {
            if (leftlis[i] != 1 && rightlis[i] != 1) rets = Math.min(rets, i+1-leftlis[i]+n-i-rightlis[i]);
        }
        return rets;
    }
}
