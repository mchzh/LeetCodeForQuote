class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null && nums.length < 3) return false;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         for (int k = j + 1; k < nums.length; k++) {
        //             if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
        //         }
        //     }
        // }
//         int curMin = Integer.MAX_VALUE;
//         for (int j = 0; j < nums.length; j++) {
//             curMin = Math.min(curMin, nums[j]);
//             if (curMin == nums[j]) continue;
            
//             // from right to left
//             for (int k = nums.length-1; k > j; k--) {
//                 if (nums[k] < nums[j] && nums[k] > curMin) return true;
//             }
//         }
//         return false; //O(n2) solution
        int n = nums.length;
        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(nums[i-1], leftMin[i-1]);
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            int second = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                second = stack.pop();
            }
            if (second > leftMin[i]) return true;
            stack.push(nums[i]);
        }
        return false;
    }
}

//         X
        
//               X     
//   X
//         i i+1
  

// stack :

//      scan from right to left
              
//             Z             X              
//                  Y       X
//                C        X
//                        X
                        
