class Solution {
    public void findErrorNums(int[] nums) {
        int[] indexsorting = insert(nums, 0, 0);
        
        for (int i = 1; i < indexsorting.length; i++) {
            while (indexsorting[i] != i && indexsorting[i] >= 0 && indexsorting[i] < indexsorting.length
                  && indexsorting[i] != indexsorting[indexsorting[i]]) {
                // swap
                int temp = indexsorting[indexsorting[i]];
                indexsorting[indexsorting[i]] = indexsorting[i];
                indexsorting[i] = temp;
            }
        }
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
