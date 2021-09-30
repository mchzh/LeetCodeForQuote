class Solution {
    private int getCount(int[] arrs, int tar) {
        int left = 0;
        int sum = 0;
        int count = 0;
    
        for (int i = 0; i < arrs.length; i++) {
            sum += arrs[i];
            while (sum > tar) {
                sum -= arrs[left];
                left++;
            }
            count += i-left+1;
        }

        return count;
    }
}

// X X X X X X X 
//   [        ]

// [1,9,4,9,7]
// 4
// [2,9,2,10,7]
// 1
// [2,1,3]
// 4
// [3,3,5,5]
// 7
// [3,3,5,5,3,4,5,5,99,100,1000,999,10000,9999,239,3483,43,212,309,1000]
// 69
