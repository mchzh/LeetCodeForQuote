class Solution {
    // extend 84
    // for every row to ensure how height 1 for every column then get the max rectangle
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int rets = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                heights[j] = ((matrix[i][j] == '0') ? 0 : (heights[j] + 1));
                // if (matrix[i][j] == '0') {
                    
                //     heights[j] = 0;
                // } else {
                    
                //     heights[j] += 1;
                // }
                
            }
    
            rets = Math.max(rets, largestRectangleArea(heights));
        }
        return rets;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] vHeights = new int[n+2];
        for (int i = 0; i < n; i++) {
            vHeights[i+1] = heights[i];
        }
        int rets = 0;
        Stack<Integer> stack = new Stack<>(); // store the index of heights
        for (int i = 0; i < n+2; i++) {
            int h = vHeights[i];
            // if (stack.isEmpty() || h >= vHeights[stack.peek()]) {
            //     stack.push(i);
            //     continue;
            // }
            while (!stack.isEmpty() && h < vHeights[stack.peek()]) {
                int recH = vHeights[stack.peek()];
                stack.pop();
                // get area of current rectangle
                // next top ensure the curent h reach out most left position
                //System.out.println(recH + " : " + i + " : " + stack.peek());
                rets = Math.max(rets, recH*(i-stack.peek()-1));
            }
            // current index always added into mono stack 
            stack.push(i);
        }
        return rets;
    }
}
