class Solution {
    // LCS -> LIS
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            if (!map.containsKey(a)) continue;
            list.add(map.get(a));
        }
        
        // LIS
        List<Integer> lisQueue = new ArrayList<>();
        for (int l : list) {
            if (lisQueue.size() == 0 || l > lisQueue.get(lisQueue.size()-1)) {
                lisQueue.add(l);
            } else {
                // get insert pos then update
                int pos = Collections.binarySearch(lisQueue, l);
                if (pos < 0) {
                    lisQueue.set(-pos-1, l);
                }
            }
        }
        return target.length - lisQueue.size();
    }
}

// target: [X X a X b d X]
// arr:    [X a X b X X d]
// => lcs: longest common sequence
// O(n2)
// dp[i][j]: the longest common sequence between a[0...i] and b[0....j]

// depends on i-1 and j-1
// for i in a
//   for j in b
//     if (a[i] == b[j]) {
//         dp[i][j] = dp[i-1][j-1] + 1;
//     } else {
//         dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
//     }
// 1e5 is impossible

// consider O(nlogn) with unique integer element

// [a, b, c, d, e, ...]
// [f, a, g, b, u, x, c]
// num -> index as a increasing order sequence
// lis -> monotonic increasing stack

// [1, 3, 7, 10] 6 
