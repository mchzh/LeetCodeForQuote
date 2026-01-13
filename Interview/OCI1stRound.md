// ##
// # Given an array of numbers and a target, find the length of the shortest subarray for which the sum is equal to target

// # 1. 
// # Input: nums = [5, 1, 3, 2, 5, 6, 9], target = 10
// # Output: 3 (Sum of [3,2,5] = 10)

// # 2. 
// # Input: nums = [1,4], target = 1
// # Output: 1 
// #
// left, right
// left  .... right (presum <= target)
// presum > target: left + 1step 
