class Solution {
    // https://leetcode.com/problems/hand-of-straights/solution/
    // sort
    // hashmap
    public boolean isNStraightHand(int[] hand, int W) {
//         int len = hand.length;
//         if (len%W != 0) return false;
//         int max = 0;
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < len; i++) {
//             max = Math.max(max, hand[i]);
//             min = Math.min(min, hand[i]);
//         }
//         int[] bucket = new int[max+W+1-min];
//         for (int i = 0; i < len; i++) {
//             bucket[hand[i]-min]++;
//         }
        
//         for (int i = 0; i < len/W; i++) {
//             for (int j = 0; j < max+W+1-min; j++) {
//                 if (bucket[j]>0) {
//                     for (int k = j; k < j+W; k++) {
//                         bucket[k]--;
//                     }
//                     break;
//                 }
//             }
//         }
//         for (int i = 0; i < max+W+1-min; i++) {
//             if (bucket[i]<0) return false;
//         }
//         return true;
        if (hand.length % W != 0) return false;
        Counter counter = new Counter();
        for (int num : hand) counter.add(num, 1);
        for (int num : hand) {
            if (counter.get(num-1) > 0 || counter.get(num) == 0) continue;
            int groupNum = 0;
            while (groupNum < W) {
                if (counter.get(num) == 0) return false;
                counter.add(num, -1);
                num++;
                groupNum++;
            }
        }
        return true;
    }
    
    class Counter extends HashMap<Integer, Integer> {
        public int get(int key) {
            return this.containsKey(key) ? super.get(key) : 0;
        }
        public void add(int key, int num) {
            this.put(key, this.get(key)+num);
        }
    }
}
