class Solution {
    // greedy : sort + PQ
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int[][] person = new int[n][2];
        for (int i = 0; i < n; i++) {
            person[i][0] = wage[i];
            person[i][1] = quality[i];
        }
        
        Arrays.sort(person, (a, b) -> (Double.compare(a[0]*1.0/a[1], b[0]*1.0/b[1])));
        
        double rets = Double.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int quality_sum = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = person[i];
            
            double unitepage = cur[0]*1.0/cur[1];
            //System.out.println(i + " " + cur[0] + " " + cur[1] + " " + unitepage);
            quality_sum += cur[1];
            
            while (pq.size() > k-1) {
                quality_sum -= pq.poll();
            }
            if (pq.size() == k-1) {
                rets = Math.min(rets, unitepage*quality_sum);
            }
            pq.offer(cur[1]);
        }
        return rets;
    }
}

// wageearn[i] / quality[i] = unitePage
// => wageearn[i] >= wageexpect[i](wage)
//     wageearn[i]/quality[i] >= wageexpect[i]/quality[i]
//     unitePage >= wageexpect[i]/quality[i]
// for every fixed max unite page on this k group, sort with unitepage
// unitePage1, unitePage2, ....., unitePagett, unitePaget+1, ...

// payment = unitePages * quality_sum (pq)
