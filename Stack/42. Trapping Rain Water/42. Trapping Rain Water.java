class Solution {
    public int trap(int[] height) {
        //left curr highest height
        //right curr highest height
        if (height == null || height.length == 0) return 0;
        int curleft = 0;
        int[] leftheight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (curleft > height[i])    leftheight[i] = curleft-height[i];
            curleft = Math.max(curleft, height[i]);
        }
        // from right to left
        int curright = 0;
        int[] rightheight = new int[height.length];
        for (int i = height.length-1; i >= 0; i--) {
            if (curright > height[i])    rightheight[i] = curright-height[i];
            curright = Math.max(curright, height[i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftheight[i], rightheight[i]);
        }
        return res;
    }
}
