class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int count = 0;
        for (int d : data) {
            count += (d == 1) ? 1 : 0;
        }
        if (count < 2) return 0;
        
        int left = 0, right = 0;
        int curcount = 0;
        int rets = Integer.MAX_VALUE;
        for (right = 0; right < n; right++) {
            if (data[right] == 1) curcount++;
            while (left < right && right-left+1 > count) {
                if (data[left] == 1) curcount--;
                left++;
            }
            int len = right-left+1;
            if (count == len) rets = Math.min(rets, len-curcount);
        }
        return rets;
    }
}
