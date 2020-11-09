class Solution {
    // priority queue save the diff floor to curr and curr to ceil
    public String minimizeError(String[] prices, int target) {
        float rets = 0;
        PriorityQueue<Double> diffHeap = new PriorityQueue<>();
        for (String p : prices) {
            float cur = Float.valueOf(p);
            double low = Math.floor(cur);
            double high = Math.ceil(cur);
            
            if (low != high) { // exist diff
                diffHeap.offer( (high-cur)-(cur-low) );
            }
            rets += cur-low;
            target -= low;
        }
        
        if (target < 0 || target > diffHeap.size()) return "-1"; // min and max
        
        while (target-- > 0) {
            rets += diffHeap.poll();
        }
        
        return String.format("%.3f", rets);
    }
}

//  floor x - x : x - ceil x
 
//    X X X X X 
// f  Y Y Y Y Y   min sum
// c  Z Z Z Z Z   max sum
// target > min < max
