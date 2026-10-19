class Solution {
    // Deque + Binary search
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // Deque<Integer> deque = new ArrayDeque<>();
        // long sum = 0;
        // int left = 0;
        // int ans = 0;

        // for (int right = 0; right < chargeTimes.length; right++) {
        //     sum += runningCosts[right];

        //     // Maintain a decreasing deque of charge times.
        //     while (!deque.isEmpty()
        //             && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
        //         deque.pollLast();
        //     }
        //     deque.offerLast(right);

        //     // Shrink the window until its cost fits the budget.
        //     while (!deque.isEmpty()
        //             && (long) chargeTimes[deque.peekFirst()]
        //                + (right - left + 1L) * sum > budget) {
        //         if (deque.peekFirst() == left) {
        //             deque.pollFirst();
        //         }

        //         sum -= runningCosts[left];
        //         left++;
        //     }

        //     ans = Math.max(ans, right - left + 1);
        // }

        // return ans;
        int left = 0, right = chargeTimes.length;
        //System.out.println(right);
        while (left < right) {
            int mid = right - (right-left)/2;
            //System.out.println(left + " : " + right + " : " + mid + " : " + isValid(mid, chargeTimes, runningCosts, budget));
            if (isValid(mid, chargeTimes, runningCosts, budget)) {
                left = mid;
            } else {
                right = mid-1;
            }   
        }
        return left;
    }
    private boolean isValid(int k, int[] chargeTimes, int[] runningCosts, long budget) {
        // keep k window
        int n = chargeTimes.length;
        long sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sum += runningCosts[i];
            // remove the less then element from end to start
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (!deque.isEmpty() && deque.peekFirst() < i-k+1 ) { 
                //[i-k+1, i] -> k size
                deque.pollFirst();
            }

            if (i >= k-1) {
                long curr = sum*k;
                if (!deque.isEmpty()) {
                    curr += chargeTimes[deque.peekFirst()];
                }
                if (curr <= budget) return true;
                sum -= runningCosts[i-k+1];
            }
        }
        //sum *= k;

        
        return false;
    }
}
