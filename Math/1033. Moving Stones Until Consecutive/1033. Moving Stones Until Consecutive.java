class Solution {
    /*Edge case 1: all three stones are next to each other (z - x == 2). Return {0, 0}.
Edge case 2: two stones are next to each other, or there is only one space in between. Minimum moves is 1.*/
    public int[] numMovesStones(int a, int b, int c) {
        int[] s = {a, b, c};
        Arrays.sort(s);
        if (s[2]-s[0] == 2) return new int[] {0, 0};
        else return new int[] {Math.min(s[2]-s[1], s[1]-s[0]) <= 2 ? 1 : 2 , s[2] - s[0] - 2};
    }
}

/*class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] sorted = new int[3];
        sorted[0] = a;
        sorted[1] = b;
        sorted[2] = c;
        Arrays.sort(sorted);
        int min = 0;
        int max = 0;
        max += sorted[1]-sorted[0] == 1 ? 0 : sorted[1]-sorted[0]-1;
        min += sorted[1]-sorted[0] == 1 ? 0 : 1;
        max += sorted[2]-sorted[1] == 1 ? 0 : sorted[2]-sorted[1]-1;
        min += sorted[2]-sorted[1] == 1 ? 0 : 1;
        int[] res = new int[2];
        if (sorted[1]-sorted[0]-1 == 1 || sorted[2]-sorted[1]-1 == 1) {
            min = 1;
        }
        if (min >= 2) min = 2;
        res[0] = min;
        res[1] = max;
        return res;
    }
}*/
