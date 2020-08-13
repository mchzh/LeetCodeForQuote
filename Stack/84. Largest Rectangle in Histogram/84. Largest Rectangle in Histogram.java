class Solution {
    // histogram
    public int largestRectangleArea(int[] heights) {
        // increasing stack
        int ret = 0;
        if (heights == null || heights.length == 0) return ret;
        int[] H = new int[heights.length+2];
        for (int i = 0; i < heights.length; i++) {
            H[i+1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < H.length; i++) {
            if (stack.isEmpty() || H[i] >= H[stack.peek()]) {
                stack.push(i);
                continue;
            }
            if (H[stack.peek()] > H[i]) {
                while (H[stack.peek()] > H[i]) {
                    int areaH = H[stack.peek()];
                    stack.pop();
                    //System.out.println(stack.peek());
                    int areaW = i-stack.peek()-1;
                    //System.out.println(areaH + " : " + areaW);
                    ret = Math.max(ret, areaH*areaW);
                }
                stack.push(i);
            }
        }
        return ret;
    }
}

/*class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)return 0;
        
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        left[0] = -1;
        for(int i=1;i<heights.length;i++){
            int index = i-1;
            int temp = heights[index];
            while(index>=0&&temp>=heights[i]){
                index = left[index];
                if(index>=0)temp = heights[index];
            }
            left[i] = index;
        }
        
        right[heights.length-1] = heights.length;
        for(int i=heights.length-2;i>=0;i--){
            int index = i+1;
            int temp = heights[index];
            while(index<heights.length&&temp>=heights[i]){
                index = right[index];
                if(index<heights.length)temp = heights[index];
            }
            right[i] = index;
        }
        
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int area = (right[i]-left[i]-1)*heights[i];
            if(area>res)res = area;
        }
        return res;
        
    }
}*/
