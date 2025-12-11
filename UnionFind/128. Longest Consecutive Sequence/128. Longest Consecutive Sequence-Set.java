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
