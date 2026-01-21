private void union(int x, int y, int[] parent) {
        int rootx = find(x, parent);
        int rooty = find(y, parent);

        if (rootx < rooty) {
            parent[rooty] = rootx;
        } else {
            parent[rootx] = rooty;
        }
    }

    private int find(int x, int[] parent) {
        //System.out.println("parent idx : " + x);
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
