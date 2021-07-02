class Solution {
    // subarray
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-k;
        
        while (left < right) {
            int mid = left + (right-left)/2;
            if (x-arr[mid] > arr[mid+k]-x) {
                left = mid+1;
            } else right = mid;
        }
        
        List<Integer> rets = new ArrayList<>();
        for (int i = left; i < left+k; i++) {
            rets.add(arr[i]);
        }
        return rets;
    }
}

// |________|  k size widnow
//       x
