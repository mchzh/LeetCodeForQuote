class Solution {
    // convert to 1D area array
    int[] areas;
    int sum;
    int[][] rects;
    public Solution(int[][] rects) {
        int N = rects.length;
        sum = 0;
        areas = new int[N];
        this.rects = rects;
        for (int i = 0; i < N; i++) {
            // cal the current rec includes how many points
            sum += (rects[i][3]- rects[i][1]+1) * (rects[i][2]- rects[i][0]+1); // wid * hei
            areas[i] = sum;
        }
        
    }
    
    public int[] pick() {
        Random rand = new Random();
        int num = rand.nextInt(sum) + 1;
        //System.out.println(num);
        int ithRect = Arrays.binarySearch(areas, num);
        if (ithRect < 0) {
            ithRect = (-1) * ithRect -1;
        }
        int height = rects[ithRect][3]-rects[ithRect][1]+1;
        int width = rects[ithRect][2]-rects[ithRect][0]+1;
        Random randHei = new Random();
        Random randWid = new Random();
        return new int[] {rects[ithRect][0]+randWid.nextInt(width), rects[ithRect][1]+randHei.nextInt(height)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */

// rand()%M => [0, M-1]

// ---2*2=4----|   ---2*3=6----|   ---1*1=1----|
// 0                                          M-1

//     11 =>[0, 10] : 7
    
//     [4, 10, 11] : increasing sequence with binary search
//     the first element more and euqal than 7
