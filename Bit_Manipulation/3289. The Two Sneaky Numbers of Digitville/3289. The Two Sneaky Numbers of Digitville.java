class Solution {
    // xor bit
    // 260. Single Number III
    public int[] getSneakyNumbers(int[] nums) {
        // use xor to get the distinct two number value: x^y = a
        // -> xor the array 0...n-1 and additiona x and y([0,,,,n-1])
        // -> xor again 0...n-1, to remove make all only once to remove;
        // [0.....n-1, x,  y, 0.....n-1] convert to array same with 260
        int x = 0;
        int n = nums.length - 2;
        for (int a : nums) x ^= a;
        for (int i = 0; i < n; i++) {
            x ^= i;
        }
        // keep the right most 1 bit on x
        int compare = x^(x&(x-1));
        // divide all arrays' number as two type:
        // 1. has 1 value on the right most postion
        // 2. has 0 value on the right most position
        // then every type array to xor is x or y
        int a = 0, b = 0;
        for (int d : nums) {
            if ( (compare&d) != 0) {
                a ^= d;
            } else {
                b ^= d;
            }
        }
        for (int i = 0; i < n; i++) {
            
            if ( (compare&i) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
