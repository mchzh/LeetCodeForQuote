class Solution {
    public int maxDistance(int[] position, int m) {
        // min of max: binary search for the distance
        Arrays.sort(position);
        int left = 1, right = position[position.length-1] - position[0];
        while (left < right) {
            int mid = right - (right-left)/2;
            if (isOk(mid, position, m)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
    private boolean isOk(int d, int[] position, int m) {
        int count = 0;
        for (int i = 0; i < position.length;) {
            int j = i;
            while (j < position.length && position[j] - position[i] < d) {
                j++;
            }
            if (j == position.length) return false;
            count++;
            if (count == m-1) return true;
            i = j;
        }
        return false;
    }
}
