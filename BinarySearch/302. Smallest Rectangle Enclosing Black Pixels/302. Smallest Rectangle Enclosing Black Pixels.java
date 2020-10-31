class Solution {
    // https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/discuss/75128/1ms-Concise-Java-Binary-Search-(DFS-is-4ms)
    public int minArea(char[][] image, int x, int y) {
        // brute force O(mn) -> dfs or bfs O(mn) -> binary search
        // int top = x, bottom = x;
        // int left = y, right = y;
        // for (x = 0; x < image.length; x++) {
        //     for (y = 0; y < image[0].length; y++) {
        //         if (image[x][y] == '1') {
        //             top = Math.min(top, x);
        //             bottom = Math.max(bottom, x+1);
        //             left = Math.min(left, y);
        //             right = Math.max(right, y+1);
        //         }
        //     }
        // }
        // return (right-left) * (bottom - top);
        int m = image.length, n = image[0].length
        int left = leftMost(image, 0, y, true);
        int right = rightMost(image, y, n-1, true);
        int top = leftMost(image, 0, x, false);
        int bottom = rightMost(image, x, m-1, false);
        
        return (right-left+1) * (bottom - top+1);
    }
    private int leftMost(char[][] image, int min, int max, boolean isFlat) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (!hasBlack(image, mid, isFlat)) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    private int rightMost(char[][] image, int min, int max, boolean isFlat) {
        int l = min, r = max;
        while (l < r) {
            int mid = r - (r-l) / 2;
            if (!hasBlack(image, mid, isFlat)) {
                r = mid-1;
            } else {
                l = mid;
            }
        }
        return l;
    }
    
    private boolean hasBlack(char[][] image, int cur, boolean isFlat) {
        if (isFlat) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][cur] == '1') return true;
            }
            return false;
        } else {
            for (int j = 0; j < image[0].length; j++) {
                if (image[cur][j] == '1') return true;
            }
            return false;
        }
    }
}
