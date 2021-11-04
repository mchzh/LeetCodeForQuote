class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
    int n = 0;
    
    Set<Long> rets = new HashSet<>();
    public int countCombinations(String[] pieces, int[][] positions) {
        n = pieces.length;
        
        for (int state = 0; state < (1<<(3*n)); state++) {
            //  every piece direction
            int[] dval = new int[n];
            int flag = 0;
            for (int i = 0; i < n; i++) {
                int d = (state>> (3*i)) % 8;
                // queen any direction, rook to direct, bishop to diagnose
                if (pieces[i].equals("rook") && d > 3) {
                    flag = 1;
                    break;
                }
                if (pieces[i].equals("bishop") && d < 4) {
                    flag = 1;
                    break;
                }
                dval[i] = d;
            }
            //System.out.println("direction -> " + " " + state + " " + flag);
            if (flag == 0) dfs(positions, dval, (1<<n)-1);
        }
        
        return rets.size() + 1;
    }
    
    private void dfs(int[][] positions, int[] d, int state) {
        for (int subset=state; subset>0; subset=(subset-1)&state)
        {
            int flag = 0;
            // any move substrate
            int[][] newpos = new int[n][2];
            // copy
            for (int i = 0; i < n; i++) {
                newpos[i][0] = positions[i][0];
                newpos[i][1] = positions[i][1];
            }
            
            for (int i = 0; i < n; i++) { // the i-th piece
                if ( ((subset>>i)&1) == 1) {
                    // next pos
                    newpos[i][0] += dirs[d[i]][0];
                    newpos[i][1] += dirs[d[i]][1];
                    if (newpos[i][0] < 1 || newpos[i][0] > 8) {
                        flag = 1;
                        break;
                    }
                    if (newpos[i][1] < 1 || newpos[i][1] > 8) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) continue;
            
            if (duplicate(newpos)) continue; // two pieces collision
            
            
            // for (int i = 0; i < newpos.length; i++) {
            //     System.out.println("new direction pos -> " + i + " " + newpos[i][0] + " " + newpos[i][1]);
            // }
            long unique = getHash(newpos);
            //System.out.println(state + " " + subset + " " + duplicate(newpos) + " " + unique);
            if (rets.contains(unique)) continue;
            rets.add(unique);
            dfs(newpos, d, subset);
        }
    }
    private boolean duplicate(int[][] p) {
        // compare every two
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] cur = p[i];
                int[] to = p[j];
                if (cur[0] == to[0] && cur[1] == to[1]) return true;
            }
        }
        return false;
    }
    private long getHash(int[][] p) {
        long rets = 0;
        for (int i = 0; i < n; i++) {
            rets = rets*10 + p[i][0];
            rets = rets*10 + p[i][1];
        }
        return rets;
    }
}

// direction for n piece

// xxx xxx xxx xxx -> bitmask

// move state:
// 1111 => 1111
//         1110
    
// A(0), B(1)
