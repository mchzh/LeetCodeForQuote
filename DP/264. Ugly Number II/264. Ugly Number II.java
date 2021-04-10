class Solution {
    // three pointer: represent * which num
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int rets = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n-1; i++) {
            rets = Math.min(list.get(a)*2, Math.min(list.get(b)*3, list.get(c)*5));
            if (list.get(a)*2 == rets) a++;
            if (list.get(b)*3 == rets) b++;
            if (list.get(c)*5 == rets) c++;
            list.add(rets);
        }
        return rets;
    }
}

// {...C...B..A} x -> y // every time to add the next min

// q[a] = A*2       q[a]*2
// q[b] = B*3(min)  q[b+1]*3
// q[c] = C*5       q[c]*5
