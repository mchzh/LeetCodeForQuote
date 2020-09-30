class Solution {
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
