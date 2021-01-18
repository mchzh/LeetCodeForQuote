class Solution {
    // https://leetcode.com/problems/maximum-number-of-ones/discuss/377159/Java-easy-to-understand
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        // loop the top-left square with sidelength
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> (b-a) );
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                int count = getCount(i, j, width, height, sideLength);
                pq.offer(count);
            }
        }
        
        int rets = 0;
        for (int i = 0; i < maxOnes; i++) {
            rets += pq.poll();
        }
        return rets;
    }
    private int getCount(int x, int y, int w, int h, int side) {
        int count = (w/side) * (h/side) + ( (x < w%side) ? h/side : 0) + ( (y < h%side) ? w/side : 0) + ( (x < w%side) && (y < h%side) ? 1 : 0 );
        return count;
    }
}

/*class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int M = sideLength * sideLength;
        if(maxOnes >= M) return width * height;
        
        int[] res = new int[M];
        for(int i = 0; i < sideLength; i++){
            for(int j = 0; j < sideLength; j++){
                res[i * sideLength + j] = ((width - i - 1) / sideLength + 1) * ((height - j - 1) / sideLength + 1);
            }
        }
        Arrays.sort(res);
        int sum = 0;
        for(int i = M - 1, j = 0; j < maxOnes; i--, j++){
            sum += res[i];
        }
        
        return sum;
    }
}*/
