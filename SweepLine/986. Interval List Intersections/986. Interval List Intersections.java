class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // sweep line
        List<int[]> sweep = new ArrayList<>();
        for (int[] f : firstList) {
            sweep.add(new int[] {f[0], 1});
            sweep.add(new int[] {f[1], -1});
        }
        for (int[] f : secondList) {
            sweep.add(new int[] {f[0], 1});
            sweep.add(new int[] {f[1], -1});
        }
        Collections.sort(sweep, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        
        List<int[]> list = new ArrayList<>();
        int count = 0;
        int start = 0, end = 0;
        for (int[] l : sweep) {
            count += l[1];
            if (count == 2 && l[1] == 1) {
                start = l[0];
            } else if (count == 1 && l[1] == -1) {
                end = l[0];
                list.add(new int[] {start, end});
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
