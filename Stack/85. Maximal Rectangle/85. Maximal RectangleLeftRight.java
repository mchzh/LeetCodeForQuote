class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int max = 0;
        
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int[] height = new int[matrix[0].length];
        
        Arrays.fill(right, matrix[0].length);
        
        for(int i=0; i<matrix.length; i++) {
            int mostLeft = 0;
            int mostRight = matrix[0].length;
            
            // for left[]
            for(int j=0; j<matrix[0].length; j++) {
                
                if(matrix[i][j]=='1') {
                    left[j] = Math.max(left[j], mostLeft);
                } else {
                    left[j] = 0;
                    mostLeft = j+1;
                }
            }
                
            // for right[]
            for(int j=matrix[0].length-1; j>=0; j--) {
                if(matrix[i][j]=='1') {
                    right[j] = Math.min(mostRight, right[j]);
                } else {
                    right[j] = matrix[0].length;
                    mostRight = j;
                }
            }
                
            // for height[]
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]=='1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
        
            for(int j=0; j<matrix[0].length; j++) {
                // System.out.println(left[j] + " " + right[j] +" " + height[j]);
                max = Math.max(max, (right[j]-left[j]) * height[j]);
            }
            
        }
        return max;
    }
}
