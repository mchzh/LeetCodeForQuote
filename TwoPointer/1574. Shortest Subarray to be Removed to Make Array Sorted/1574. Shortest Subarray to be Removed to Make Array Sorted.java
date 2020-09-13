class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int N = arr.length;
        int ret = N-1; // only left the one element
        int left = 0, right = N-1;
        // while (left + 1< N && arr[left]<= arr[left+1]) {
        //     left++;
        // }
        while (right-1 >= 0 && arr[right-1] <= arr[right]) {
            right--;
        }
        
        ret = Math.min(ret, right); // the first j number can be removed
        if (ret == 0) return ret;
        // based on left val to move right
        //[0...left]: sorted prefix  ->  [right, N-1] sorted suffix
        int j = right;
        for (left = 0; left < right; left++) {
            // non-increasing prefix
            if (left > 0 && arr[left] < arr[left-1]) break;
            while (j < N && arr[j] < arr[left]) {
                j++;
            }
            
            ret = Math.min(ret, j-left-1);
        }
        return ret;
    }
}

// [X X X X X][X X][X X X X]
// 0........i       j.....n-1
// 1. [0..i] increasing;
// 2. [j...n-1] increasing;
// 3. arr[i] <= arr[j]
