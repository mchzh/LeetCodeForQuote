class Solution {
    // 2d binary search + recursion
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        int x1 = bottomLeft[0], x2 = topRight[0];
        int y1 = bottomLeft[1], y2 = topRight[1];
        
        if (x1 == x2 && y1 == y2) return 1;
        int x3 = (x1+x2)/2, y3 = (y1+y2)/2;
        int a = 0, b = 0, c = 0, d = 0;
        
        int[] mid = new int[] {x3, y3};
        int[] rightm = new int[] {x2, y3};
        int[] bottomm = new int[] {x3+1, y1};
        int[] topm = new int[] {x3, y2};
        int[] leftm = new int[] {x1, y3+1};
        int[] midone = new int[] {x3+1, y3+1};
        if (x3 >= x1 && y3 >= y1) 
            a = countShips(sea, mid, bottomLeft);
        
        if (x2 >= x3+1 && y3 >= y1)
            b = countShips(sea, rightm, bottomm);
        if (x3 >= x1 && y2 >= y3+1)
            c = countShips(sea, topm, leftm);
        if (x2 >= x3+1 && y2 >= y3+1)
            d = countShips(sea, topRight, midone);
        
        return a+b+c+d;
    }
}
