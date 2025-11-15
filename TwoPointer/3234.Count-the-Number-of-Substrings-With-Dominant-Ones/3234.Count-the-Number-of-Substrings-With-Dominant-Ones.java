class Solution {
    // two pointer
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int rets = 0;
        int[] right = new int[n];
        for (int i = n-2; i >= 0; i--) {
            if (s.charAt(i+1) == '1') {
                right[i] = right[i+1] + 1;
            }
            //System.out.println(i + " : " + right[i]);
        }
        
        for (int m = 1; m <= 200; m++) {
            int j = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && count < m) {
                    count += (s.charAt(j) == '0' ? 1 : 0);
                    j++;
                }
                if (count != m) break; // not m size window

                int have = j-i-count; // how many '1' of this slide window
                // count* count is zero comparision
                // right[x] how many secutiove 1 on the right of x
                if (right[j-1] + have >= count * count) {
                    //System.out.println(i + " : " + j + " : " + right[j-1] + " : " + count + " : " + m);
                    int extra = right[j-1] - Math.max(0, (count * count - have)); // negative possibility
                    rets += Math.max(0, extra+1);
                }
                
                

                count -= (s.charAt(i) == '0' ? 1 : 0);
            }
        }
        //System.out.println(rets);
        // m == 0 need to specific handle, consective 1
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') rets += right[i]+1;
        }
        return rets;
    }
}
// fix i to move j
// X X X X X 
// X X Xj [X X X X i] X X
// i: x:1, y:0
// j: p:1 q:0
// x-p >= (y-q)^2
// x-p >= y^2 -2yq + q^2
// q^2 -2yq +p <= x - y^2
// no regular pattern to trace

// another idea: squar means dense 0
// most 200
// 200 : 0 need 4*10^4 1
// fix slide window with m 0 then move extend left and right for consective 1
// 1..1 {0, x,x,x, 0} 1 ... 1

// convert to fix left positon no matter 1 or 0 
// .. [i, x,x,x,x] j,...1
//     m 0 to j-1 position
//     tranverse m then second loop use left and right pointer to get substring number
