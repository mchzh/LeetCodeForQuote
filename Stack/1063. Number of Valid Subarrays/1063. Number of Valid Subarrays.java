class Solution {
    public int validSubarrays(int[] nums) {
        int[] newNums = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) newNums[i] = nums[i];
        newNums[nums.length] = Integer.MIN_VALUE;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < newNums.length; i++) {
            while (!stack.isEmpty() && newNums[stack.peek()] > newNums[i]) {
                count += i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return count;
    }
}

// X X
// next smaller element
// 5 6 7 8 9   4
// i       j-1 j 

// 1 2 3 4 5
