class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // slide window
        int N = customers.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        
        // right point
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (grumpy[i] == 1) sum += customers[i];
            if (i-X >= 0 && grumpy[i-X] == 1) sum -= customers[i-X];
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}

/*class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int left = 0;
        int right = 0;
        int max = sum;
        while (right < customers.length) {
            if (grumpy[right] == 1) sum += customers[right];
            
            while (right - left > X - 1) {
                if (grumpy[left] == 1) sum -= customers[left];
                left++;
            }
            if (right - left == X - 1) {
                max = Math.max(max, sum);
            }
            right++;
        }
        return max;
    }
}*/
