class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] newnums = insert(nums, 0, 0);
        
        for (int i = 1; i < newnums.length; i++) {
            while (newnums[i] != i && newnums[i] >= 0 && newnums[i] < newnums.length
                  && newnums[i] != newnums[newnums[i]]) {
                // swap
                int temp = newnums[newnums[i]];
                newnums[newnums[i]] = newnums[i];
                newnums[i] = temp;
            }
        }
        
        int[] rets = new int[2];
        for (int i = 1; i < newnums.length; i++) {
            if (newnums[i] != i) {
                rets[0] = newnums[i];
                rets[1] = i;
                break;
            }
        }
        return rets;
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
