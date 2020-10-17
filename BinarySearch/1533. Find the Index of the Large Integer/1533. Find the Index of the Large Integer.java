/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0, right = reader.length()-1;
        while (left+1 < right) {
            int mid = left + (right - left)/2; // right-(right-left)/2;
            int compare = reader.compareSub(left, (right-left+1) %2==0 ? mid : mid-1, mid+1, right);
            if ( (right-left+1) %2 == 0 ) {
                if (compare > 0) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            } else {
                if (compare == 0) {
                    return mid;
                } else if (compare > 0){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        //System.out.println("last left : " +left + " - accompany right -> " + right);
        if (reader.compareSub(left, left, right, right) > 0) return left;
        else return right;
    }
}
