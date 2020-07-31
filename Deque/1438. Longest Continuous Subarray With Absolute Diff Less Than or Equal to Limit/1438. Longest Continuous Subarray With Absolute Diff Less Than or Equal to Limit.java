class Solution {
    // two heap : max heap and min heap
    public int longestSubarray(int[] nums, int limit) {
        //left and right + heap
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        maxQ.offerLast(0);
        minQ.offerLast(0);
        int mx = nums[0], mn = nums[0];
        int j = 0;
        int ret = 1;
        
        for (int i = 0; i < nums.length; i++) {
            
            while (mx-mn <= limit) {
                // update mx and mn
                
                ret = Math.max(ret, j-i+1);
                j++;
                
                if (j == nums.length) break;
                //System.out.println(maxQ.getLast());
                while (maxQ.size() > 0 && nums[j] >= nums[maxQ.getLast()]) {
                    maxQ.pollLast();
                }
                //System.out.println("curr index -> " + j);
                maxQ.offerLast(j);
                mx = nums[maxQ.getFirst()];
                
                while (minQ.size() > 0 && nums[j] <= nums[minQ.getLast()]) {
                    minQ.pollLast();
                }
                minQ.offerLast(j);
                mn = nums[minQ.getFirst()];
            }
            
            if (j == nums.length) break;
            
            if (maxQ.size() > 0 && i == maxQ.peekFirst() ) {
                maxQ.pollFirst();
                mx = nums[maxQ.getFirst()];
            }
            if (minQ.size() > 0 && i == minQ.peekFirst() ) {
                minQ.pollFirst();
                mn = nums[minQ.getFirst()];
            }
        }
        return ret;
    }
}

// naiive: O(NK)
// heap: O(Nlogk)
// Deque: O(N)
