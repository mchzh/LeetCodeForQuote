class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (start[c-'a'] == -1) start[c-'a'] = i;
        }
        for (int i = n-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (end[c-'a'] == -1) end[c-'a'] = i;
        }
        // find all valid interval based on start with char
        List<int[]> interval = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (start[i] == -1) continue; // no element occur
            int left = start[i], right = end[i];
            boolean isValid = true;
            for (int k = left; k <= right; k++) {
                char c = s.charAt(k);
                if (start[c-'a'] < left) {
                    // start pos change is invalid
                    isValid = false;
                    break;
                }
                right = Math.max(right, end[c-'a']);
            }

            if (isValid) {
                interval.add(new int[]{left, right});
            }
        }
        // sort all interval then compare them every two
        interval.sort(Comparator.comparingInt(e -> e[1]-e[0]));

        // two - two comparing
        boolean[] flag = new boolean[interval.size()];
        Arrays.fill(flag, true);
        for (int i = 0; i < interval.size(); i++) {
            for (int j = i+1; j < interval.size(); j++) {
                // cover
                int[] a = interval.get(i);
                int[] b = interval.get(j);
                if (b[0] <= a[0] && a[1] <= b[1]) {
                    flag[j] = false;
                }
            }
        }
        // rets
        List<String> rets = new ArrayList<>();
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) continue;
            int[] cur = interval.get(i);
            rets.add(s.substring(cur[0], cur[1]+1));
        }
        return rets;
    }
}
// start with a...., b...., c....
// abasdebaefgh
// disjoint or cover
// fixed non-overlaping group
// "adefaddaccc" -> "adefadda", "ccc", "e", "f"
