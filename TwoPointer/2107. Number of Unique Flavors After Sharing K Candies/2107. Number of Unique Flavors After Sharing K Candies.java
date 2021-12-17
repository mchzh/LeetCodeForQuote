class Solution {
    // two point
    int[] count = new int[100005];
    public int shareCandies(int[] candies, int k) {
        int n = candies.length;
        int uniquetotal = 0;
        for (int i = 0; i < n; i++) {
            int cur = candies[i];
            count[cur]++;
            if (count[cur] == 1) uniquetotal++;
        }
        if (k == 0) return uniquetotal;
        
        int rets = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int cur = candies[i];
            if (i > k-1) {
                int remedy = candies[left];
                count[remedy]++;
                if (count[remedy] == 1) uniquetotal++;
                left++;
            }
            
            count[cur]--;
            if (count[cur] == 0) uniquetotal--;
            if (i >= k-1) rets = Math.max(rets, uniquetotal);
        }
        return rets;
    }
}

// X X X X [Y Y Y Y Y] X X X X 
//       left          i
// count from 0 -> 1 unique num + 1
// count from 1 -> 0 unique num - 1
