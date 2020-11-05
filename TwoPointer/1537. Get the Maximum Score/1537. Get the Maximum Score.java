class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long x = 0, y = 0;
        int m = nums1.length, n = nums2.length;
        int mod = (int)(1e9+7);
        
        while (i < m || j < n) {
            if (i == m) {
                y += nums2[j];
                j++;
            } else if (j == n) {
                x += nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                x += nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                y += nums2[j];
                j++;
            } else if (nums1[i] == nums2[j]) {
                x = Math.max(x+nums1[i], y+nums2[j]);
                y = x;
                i++;
                j++;
            }
        }
        
        return (int)(Math.max(x, y)%mod);
    }
}

// X X X X X O Z Z Z   O C C C
// Y Y Y Y   O S S S S O D D D
// i, j
