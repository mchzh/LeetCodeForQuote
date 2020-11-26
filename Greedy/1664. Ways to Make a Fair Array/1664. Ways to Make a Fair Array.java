class Solution {
    // presum and sufsum
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i-1];
        }
        
        // presum
        int evenSum = 0, oddSum = 0;
        int[] leftEven = new int[n+1], leftOdd = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i%2 == 0) evenSum += newNums[i];
            else oddSum += newNums[i];
            leftEven[i] = evenSum;
            leftOdd[i] = oddSum;
        }
        
        // from right to left
        int rightOdd = 0, rightEven = 0;
        int rets = 0;
        for (int i =n; i >= 1; i--) {
            if (leftEven[i-1] + rightOdd == leftOdd[i-1] + rightEven) rets++;
            
            if (i%2 == 0) rightEven += newNums[i];
            else rightOdd += newNums[i];
        }
        return rets;
    }
}

// indice
// leftEven[i-1] + rightOdd[i+1] == leftOdd[i-1] + rightEven[i+1];

/*class Solution {
    public int waysToMakeFair(int[] nums) {
        int res = 0;
        int rightOddSum = 0, rightEvenSum = 0, leftOddSum = 0, leftEvenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                rightEvenSum += nums[i];
            } else {
                rightOddSum += nums[i];
            }   
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                rightEvenSum -= nums[i];
            } else {
                rightOddSum -= nums[i];
            }
            if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum) {
                res++;
            }
            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }
        return res;
    }
}*/
