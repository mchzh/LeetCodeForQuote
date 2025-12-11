class Solution {
    public int longestConsecutive(int[] nums) {
        // two set
        Set<Integer> elements = new HashSet<>();
        for (int a : nums) {
            elements.add(a);
        }

        int n = nums.length;
        int rets = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            if (elements.contains(a-1)) continue;
            if (visited.contains(a)) continue;
            // get one lower limitation
            int count = 0;
            visited.add(a);
            while (elements.contains(a)) {
                a++;
                count++;
            }
            rets = Math.max(rets, count);
        }
        return rets;
    }
}

// version 2
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int a : nums) elements.add(a);

        int rets = 0;
        // loop set not loop nums
        for (int a : elements) {
            if (!elements.contains(a - 1)) {
                int b = a;
                while (elements.contains(b)) b++;
                rets = Math.max(rets, b - a);
            }
        }
        return rets;
    }
}
