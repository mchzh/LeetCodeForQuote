class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // total sum and remove n-k. the n-k subarray is the element which has been left
        int n = cardPoints.length;
        int distance = n-k;
        int[] presum = new int[n+1];
        int total = 0;
        int rets = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
            presum[i+1] = presum[i] + cardPoints[i];
        }
        
        for (int i = 0;i <= k; i++) {
            rets = Math.min(rets, presum[i+distance] - presum[i]);
        }
        
        return total - rets;
    }
}


// X X X X X X X X 
// ->           <-
//      [X, X] : minimun subarray
