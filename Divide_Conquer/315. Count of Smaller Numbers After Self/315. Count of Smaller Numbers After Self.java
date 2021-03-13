class Solution {
    int[] rets;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        rets = new int[n];
        int[] sorted = Arrays.copyOf(nums, n);
        helper(nums, sorted, 0, n-1);
        //return Arrays.stream(rets).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (int i : rets) list.add(i);
        return list;
    }
    
    private int getFirstHigher(int tar, int[] sorted, int a, int b) {
        int left = a, right = b;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (sorted[mid] < tar) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return sorted[left] >= tar ? left : left+1;
    }
    
    private void helper(int[] nums, int[] sorted, int a, int b) {
        // corner case
        if (a >= b) return;
        // divide
        int mid = a + (b-a)/2;
        helper(nums, sorted, a, mid);
        helper(nums, sorted, mid+1, b);
        
        // conquer
        for (int i = a; i <= mid; i++) {
            int higher = getFirstHigher(nums[i], sorted, mid+1, b);
            rets[i] += higher-(mid+1);
        }
        // merge sort
        int[] temp = new int[b-a+1];
        int i = a, j = mid+1, p = 0;
        while (i <= mid  && j <= b) {
            if (sorted[i] < sorted[j]) {
                temp[p] = sorted[i];
                i++;
                p++;
            } else {
                temp[p] = sorted[j];
                j++;
                p++;
            }
        }
        while (i <= mid) {
            temp[p] = sorted[i];
            i++;
            p++;
        }
        while (j <= b) {
            temp[p] = sorted[j];
            j++;
            p++;
        }
        for (int x = a; x <= b; x++) {
            sorted[x] = temp[x-a];
        }
    }
}
// lower_bound
// D: [W W W W W W W W W W Y Y Y Y Y Z Z Z Z Z]
// A: [W W W W W W W W W W] [Y Y Y Y Y Z Z Z Z Z] sorted
// B: [Y Y Y Y Y]  [Z Z Z Z Z]
