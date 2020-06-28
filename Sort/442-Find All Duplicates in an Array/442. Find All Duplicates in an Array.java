class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // array indexing sort
        // 4,3,2,7,8,2,3,1
        // 7,3,2,4,8,2,3,1
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //System.out.println("first loop -> " +i);
            while ( (nums[i] != i+1) && (nums[i] >=1 && nums[i] <= n) 
                   && (nums[i] != nums[nums[i]-1]) ) {
                // swap nums[i] nums[nums[i]-1];
                int temp = nums[i];
                int indexTemp = nums[i]-1;
                nums[i] = nums[nums[i]-1];
                nums[indexTemp] = temp;
            }
        }
        // another loop to find the element which not locate in suitalbe index
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) res.add(nums[i]);
        }
        return res;
    }
}

/*class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // corresponding for index set value as negative
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
                continue;
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}*/
