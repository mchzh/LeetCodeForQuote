class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // looks like don't need the input n?
        // sweep line
        int len = rectangles.length;
        int[][] horizontal = new int[2*len][2];
        int[][] vertical = new int[2*len][2];
        for (int i = 0; i < len; i++) {
            int[] cur = rectangles[i];
            horizontal[2*i][0] = cur[0];
            horizontal[2*i][1] = 1;
            horizontal[2*i+1][0] = cur[2];
            horizontal[2*i+1][1] = -1;

            vertical[2*i][0] = cur[1];
            vertical[2*i][1] = 1;
            vertical[2*i+1][0] = cur[3];
            vertical[2*i+1][1] = -1;
        }
        Arrays.sort(horizontal, (a, b) -> (a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));
        Arrays.sort(vertical, (a, b) -> (a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));
        int hcount = 0;
        int hvalidcount = 0;
        int vcount = 0;
        int vvalidcount = 0;
        for (int i = 0; i < 2*len; i++) {
            int[] hcur = horizontal[i];
            // 1, line, 2. operation +1 or -1(start or end)
            hcount += hcur[1];
            if (hcount == 0) {
                hvalidcount++;
            }
            int[] vcur = vertical[i];
            // 1, line, 2. operation +1 or -1(start or end)
            vcount += vcur[1];
            if (vcount == 0) {
                vvalidcount++;
            }
        }
        return hvalidcount >= 3 
        || vvalidcount >= 3;
    }
}

// [1,5], [0,2],[3,5],[0,4]
// sort ： [0,2] [0,4],[1,5],[3,5]
// start count+1; end count-1
// if count == 0 , this line valid
// get count valid line >= 2
