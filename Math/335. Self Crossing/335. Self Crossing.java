class Solution {
    public boolean isSelfCrossing(int[] distance) {
        // always increasing, -> always decrease -> first increase then decrease
        // add  one group virtual node (four point for four direction)
        int n = distance.length;
        int[] dis = new int[n+4];
        for (int i = 0; i < n; i++) {
            dis[i+4] = distance[i];
        }

        // check increasing
        int i = 4;
        while (i < dis.length && dis[i] > dis[i-2]) i++;

        if (i == dis.length) return false;
        // update dis[i-1]
        if (dis[i] >= dis[i-2]-dis[i-4]) dis[i-1] -= dis[i-3];

        i++;
        while (i < dis.length && dis[i] < dis[i-2]) i++;

        if (i == dis.length) return false;
        else return true;
    }
}
