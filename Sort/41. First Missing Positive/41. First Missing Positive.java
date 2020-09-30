class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        // add 0 to 0 pos for this array
        int[] copy = insert(nums, 0, 0);
        for (int i = 0; i < copy.length; i++) {
            while (copy[i] != i && copy[i] >= 0 && copy[i] < copy.length && copy[i] != copy[copy[i]]) {
                // swap
                int temp = copy[copy[i]];
                copy[copy[i]] = copy[i]; 
                copy[i] = temp;
            }
            
        }
        
        for (int i = 1; i < copy.length; i++) {
            if ( i!= copy[i] ) return i;
        }
        return copy.length;
    }
    
    private int[] insert(int[] a, int key, int index) {
        return IntStream.range(0, a.length+1)
                    .map( i -> {
                        if (i < index) {
                            return a[i];
                        } else if (i == index) {
                            return key;
                        } else {
                            return a[i-1];
                        }
                    } )
                    .toArray();
    }
}

// sort : O(nlgn)
// X X X X X X
// indexing sort
