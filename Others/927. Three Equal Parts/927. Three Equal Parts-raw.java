class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int total = 0;
        for (int a : arr) total += a;
        if (total == 0) return new int[] {0, n-1};
        if (total%3 != 0) return new int[] {-1, -1};
        
        int left = 0;
        int cur = 0;
        while (left < n && cur < total/3) {
            cur += arr[left];
            left++;
        }
        int right = n-1;
        cur = 0;
        while (right >= 0 && cur < total/3) {
            cur += arr[right];
            right--;
        }
        // fisrt part and last part
        left--;
        right++;
        //System.out.println(left + " " + right);
        int start = left+1, end = n-1;
        int countzero = 0;
        while (start < right && arr[end] == 0) {
            if (arr[start] == 0) {
                countzero++;
                start++;
                end--;
            } else {
                return new int[] {-1, -1};
            }
            
        }
        // make sure the leading zero for last part
        int countsecond = 0;
        int lastfront = right-1;
        while (lastfront > start && arr[lastfront] == 0) {
            countsecond++;
            lastfront--;
        }
        if (countsecond < countzero) return new int[] {-1, -1};
        
        start--;
        // compare this three parts
        int rone = start, rtwo = right-(countsecond-countzero)-1, rthree = n-1;
        //System.out.println(rone + " " + rtwo + " " + rthree);
        int countone = 0;
        while (countone < total/3) {
            if (arr[rone] != arr[rtwo] || arr[rtwo] != arr[rthree] || arr[rone] != arr[rthree]) return new int[] {-1, -1};
            rone--;
            rtwo--;
            rthree--;
            countone++;
        }
        
        //System.out.println(start + " " + end + " " + countzero + " " + countsecond);
        
        return new int[] {start, right-(countsecond-countzero)};
    }
}
