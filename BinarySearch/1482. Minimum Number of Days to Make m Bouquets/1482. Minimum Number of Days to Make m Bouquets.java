class Solution {
    // for days with binary search
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0, right = 0;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ( isMBouquet(bloomDay, m, k, mid) ) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        if (isMBouquet(bloomDay, m, k, left)) return left;
        else return -1;
    }
    private boolean isMBouquet(int[] bloomDay, int m, int k, int tarDay) {
        // consecutive interval
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < bloomDay.length; i++) {
        //     if (bloomDay[i] > tarDay) continue;
        //     list.add(i);
        // }
        int count = 0;
        int flow = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > tarDay) {
                flow = 0;
            } else {
                flow++;
                if (flow == k) {
                    count++;
                    flow = 0;
                }
            }
            
        }
        if (count >= m) return true;
        else return false;
    }
}
