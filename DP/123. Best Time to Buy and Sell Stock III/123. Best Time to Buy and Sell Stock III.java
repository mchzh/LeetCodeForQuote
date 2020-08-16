class Solution {
    public int maxProfit(int[] prices) {
        int hold1=Integer.MIN_VALUE, sold1=0, hold2=Integer.MIN_VALUE, sold2=0;
        
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            int hold1_old = hold1;
            int sold1_old = sold1;
            int hold2_old = hold2;
            int sold2_old = sold2;
            
            hold1 = Math.max(0-p, hold1_old);
            sold1 = Math.max(hold1_old+p, sold1_old);
            hold2 = Math.max(sold1_old-p, hold2_old);
            sold2 = Math.max(hold2_old+p, sold2_old);
        }
        
        return Math.max(sold1, sold2);
    }
}

//  3 3 5 0 0 3 1 4
//      sell[i]
//      buy[i]
     
// X X X X X i
// K day             K-1 Day
// hold1: 0-price[k], hold1[k-1]
// sold1: hold1[k-1]+price[k], sold1[k-1]
// hold2: sold1[k-1]-price[k], hold2[k-1]
// sold2: hold2[k-1]+price[k], sold2[k-1]

// hold1[k] = max(0-price[k], hold1[k-1])
// sold1[k] = max(hold1[k-1]+price[k], sold1[k-1])
// hold2[k] = max(sold1[k-1]-price[k], hold2[k-1])
// sold2[k] = max(hold2[k-1]+price[k], sold2[k-1])
