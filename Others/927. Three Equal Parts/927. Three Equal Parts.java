class Solution {
    public int[] threeEqualParts(int[] A) {
        int countone = 0;
        for (int a : A) {
            if (a == 0) continue;
            countone++;
        }
        
        if (countone%3 != 0) return new int[] {-1, -1};
        if (countone == 0) return new int[] {0, A.length-1};
        
        
        int numOfOne = countone/3;
        // to get the desired part num from the end postion
        int j = A.length-1;
        while ( numOfOne > 0 ) {
            if (A[j] == 1) numOfOne--;
            j--;
        }
        j++;
        
        int k = j;
        // check the first part
        int i = 0;
        while (i < j && A[i] == 0) i++;
        while (k < A.length) {
            if (A[i] != A[k]) return new int[] {-1, -1};
            i++;
            k++;
        }
        int first = i-1;
        
        // check the secodn part
        k = j;
        if (i >= k) return new int[] {-1, -1};
        while (i < j && A[i] == 0) i++;
        while (k < A.length) {
            if (A[i] != A[k]) return new int[] {-1, -1};
            i++;
            k++;
        }
        return new int[] {first, i};
    }
}

// X X X X i X X X X j X X X X 
//  0 0 0 1 x x x 0 x 0
    
// 0 0 0 1 x x x | 0 0 1 x x x x| 1 x x x x x|
