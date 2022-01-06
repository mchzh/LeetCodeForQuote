class Solution {
    public List<Integer> getValley(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            // valley several situation
            int cur = nums[i];
            if (i > 0 && i < n-1) {
                if (cur < nums[i-1] && cur < nums[i+1]) ans.add(i);
            } else if (i == 0) {
                if (cur < nums[i+1]) ans.add(i);
            } else if (i == n-1) {
                if (cur < nums[i-1]) ans.add(i);
            }
            
            int j = i;
            while (j < n && nums[j] == cur) j++;
            if (j-i == 1) continue;
            // range from i to j-1;
            if (i > 0 && j-1 < n-1) {
                if (cur < nums[i-1] && cur < nums[j]) ans.add(i);
            } else if (i == 0 && j < n) {
                if (cur < nums[j]) ans.add(i);
            } else if (i > 0 && j == n) {
                if (cur < nums[i-1]) ans.add(i);
            } else if (i == 0 && j == n) {
                ans.add(i);
            }
            i = j-1;
        }
        return ans;
    }
}
