class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            preSum[i+1] = preSum[i] + A[i];
        }
        int res = Integer.MAX_VALUE/2;
        Deque<Integer> queue = new LinkedList<>();
        queue.offerFirst(0);
        for (int j = 1; j < preSum.length; j++) {
            int left = Integer.MIN_VALUE/2;
            // find the first matched index
            //System.out.println(queue.size() + " : get first -> " + queue.getFirst());
            while (queue.size() > 0 && preSum[queue.getFirst()] <= preSum[j]-K) {
                left = queue.getFirst();
                queue.pollFirst();
            }
            //queue.offerLast();
            res = Math.min(res, j-left);
            
            // put the cur j index into queue
            while(queue.size() > 0 && preSum[queue.getLast()] >= preSum[j]) {
                queue.pollLast();
            }
            queue.offerLast(j);
        }
        
        // for (int i = 0; i < preSum.length; i++) {
        //     for (int j = i+1; j < preSum.length; j++) {
        //         if ( preSum[j]-preSum[i] >= K ) res = Math.min(res, j-i);
        //     }
        // }
        return res == Integer.MAX_VALUE/2 ? -1 : res;
    }
}

// presum
// [a, b, c, d, e, || f, g ---]
// fix j to search i
// for (j from 0 --- len) {
//     i = fun(set)
//     presum[j] => Set;
// }

// [A(a), B(b), C(c), D(d), E(e), F(f)]  J(j) j+1
// if c j is res, the a, b, c can be removed
// add j as monoqueue
// [A(a)-, B(b)-, C(c)-, D(d), E(e), F(f)]<- J(j)
// deque ensure two rules:
// A < B < C < D < E < F
// a < b < c < d < e < f
