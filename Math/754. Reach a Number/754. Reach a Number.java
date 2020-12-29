class Solution {
    // https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int i = 0;
        while ( !(sum >= target && (sum-target) % 2 == 0) ) {
            i++;
            sum += i;
        }
        return i;
    }
}

// sum >= target && (sum-target) % 2 == 0 is a exit condition;
//  12
//  13
//  14
// +1 +2 +3 +4 +5 +6 +7
     
//      k: +k/2 => -k+2
         
//    M: 1+2+...M +M+1 + M+2 >= target
