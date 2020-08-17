class Solution {
    // https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/discuss/470238/JavaC%2B%2BPython-Exactly-Same-as-846.-Hand-of-Straights
    public boolean isPossibleDivide(int[] nums, int k) {
        // if (nums.length % k != 0) return false;
        // Counter counter = new Counter();
        // for (int num : nums) counter.add(num, 1);
        // for (int num : nums) {
        //     if (counter.get(num-1) > 0 || counter.get(num) == 0) continue;
        //     int groupNum = 0;
        //     while (groupNum < k) {
        //         if (counter.get(num) == 0) return false;
        //         counter.add(num, -1);
        //         num++;
        //         groupNum++;
        //     }
        // }
        // return true;
        // Counter counter = new Counter();
        if (nums.length % k != 0) return false;
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : nums) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = k - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int num : nums) pq.offer(num);
        // while ( !pq.isEmpty() ) {
        //     int cur = pq.poll();
        //     for (int j = 1; j < k; j++) {
        //         if (!pq.remove(cur+j)) return false;
        //     }
        // }
        // return true;
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

/*class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i=0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            min = Math.min(min, nums[i]);
        }
        
        while (map.size() > 0) {
           int i=0;
           int count = map.getOrDefault(min, 0);
            
           while  (i < k) {
               int curCount = map.getOrDefault(min + i,0);
                if (curCount < count) {
                    return false;
                }
               
               if (curCount - count == 0) {
                   map.remove(min + i);
               } else {
                    map.put(min+i, curCount - count);
               }
               i++;
           }
            min = Integer.MAX_VALUE;
            for (i=0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                   min = Math.min(min, nums[i]); 
                }
            }
        }
        
        return true;
    }
}*/

/*class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        }
        int startIndex=0;
        while(startIndex<nums.length && map.get(nums[startIndex])>0){
            for(int i=0;i<k;i++){
                int candidate=nums[startIndex]+i;
                if(!map.containsKey(candidate) || map.get(candidate)<=0)return false;
                int cnt=map.get(candidate);
                map.put(candidate, cnt-1);
            }
            while(startIndex<nums.length && map.get(nums[startIndex])<=0){
                startIndex++;        
            }
        }
        return true;
    }
}*/
