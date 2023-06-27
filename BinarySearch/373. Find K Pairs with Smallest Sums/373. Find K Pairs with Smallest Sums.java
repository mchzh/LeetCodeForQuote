class Solution {
    // dp[i][j]
    // binary search + mono
    // https://github.com/wisdompeak/LeetCode/blob/master/Binary_Search/373.Find-K-Pairs-with-Smallest-Sums/373.Find-K-Pairs-with-Smallest-Sums_v2.cpp
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        long left = nums1[0]+nums2[0], right = nums1[nums1.length-1]+nums2[nums2.length-1];
        while (left < right) {
            long mid = left + (right-left) /2;
            long count = countLessOrEqual(mid, nums1, nums2);
            
            if (count < k) {
                left = mid+1;
            } else {
                right = mid;
            }
            //System.out.println(count + " " + k + " " + left + " " + right + " " + mid);
        }
        long m = left;
        //System.out.println(left);
        // count > k mean == m number more and select the the first
        List<List<Integer>> rets = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length && nums2[j] + nums1[i] < m) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                rets.add(list);
                j++;
            }
        }
        
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length && nums2[j] + nums1[i] <= m && rets.size() < k) {
                if (nums2[j] + nums1[i] == m) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    rets.add(list);
                }
                j++;
            }
        }
        return rets;
    }
    private long countLessOrEqual(long m, int[] nums1, int[] nums2) {
        long count = 0;
        int j = nums2.length-1;
        for (int i = 0; i < nums1.length; i++) {
            while (j >= 0 && nums2[j] + nums1[i] > m) {
                j--;
            }
            count += j+1;
        }
        return count;
    }
}
