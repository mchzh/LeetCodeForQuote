class Solution {
    // https://leetcode.com/problems/3sum/discuss/591070/JAVA-O(n2)-square-and-O(1)-space-solution-faster-than-89
    // https://fizzbuzzed.com/top-interview-questions-1/
    // https://fizzbuzzed.com/top-interview-questions-1/
    // https://leetcode.com/problems/3sum/solution/
    public List<List<Integer>> threeSum(int[] nums) {
        // not use arrays.sort, switch to hashset to save the previous element without duplicate triplets
        // a+b = -c => a = sum -b, target is -c.
        Set<Pair> found = new HashSet<>();
    Set<Integer> dups = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i = 0; i < nums.length; ++i)
        if (dups.add(nums[i]))
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.containsKey(complement) && seen.get(complement) == i) {
                    int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
                    int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
                    if (found.add(new Pair(v1, v2)))
                        res.add(Arrays.asList(nums[i], complement, nums[j]));
                }
                seen.put(nums[j], i);
            }
    return res;
    }
}

/*class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = nums.length - 1; i > 1; i--){
            if(i != nums.length - 1 && nums[i] == nums[i+1]){
                continue;
            }
            int c = nums[i];
            int l = 0;
            int r = i-1;
            twoSum(l, r, nums, -c, res);
        }
        return res;
    }
    
    public void twoSum(int l, int r, int[] nums, int target, List<List<Integer>> res){
        while(l < r){
            if(nums[l] + nums[r] < target){
                l++;
            }else if(nums[l] + nums[r] > target){
                r--;
            }else{
                List<Integer> ele = new ArrayList<>();
                ele.add(nums[l]);
                ele.add(nums[r]);
                ele.add(-target);
                res.add(ele);
                l++;
                r--;
                while(l<r && nums[l] == nums[l-1]){
                    l++;
                }
                while(l<r&&nums[r] == nums[r+1]){
                    r--;
                }
            }
        }
    }
}*/
