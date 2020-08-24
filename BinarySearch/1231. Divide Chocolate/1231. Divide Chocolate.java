class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        // binary search for sweetness (max of min)
        int sum = 0;
        for (int s : sweetness) {
            sum += s;
        }
        int left = 0, right = sum;
        while (left < right) {
            int mid = right- (right-left)/2;
            if (isOk(mid, sweetness, K)) { // get K+1 chunk with the min mid
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left; // it has to have a solution
    }
    private boolean isOk(int t, int[] sweetness, int K) {
        int sum = 0, count = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if (sum < t) continue;
            sum = 0;
            count++;
        }
        return count >= K+1;
    }
}
