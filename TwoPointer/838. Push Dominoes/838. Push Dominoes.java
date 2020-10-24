class Solution {
    //() + stack
    // https://leetcode.com/problems/push-dominoes/discuss/132520/Java-one-pass-no-extra-storage-detailed-explanation
    // two pinter
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        int n = dominoes.length();
        int i = 0, j = 0;
        char[] chars = dominoes.toCharArray();
        
        while (i < n - 1) {
            j = i+1;
            while (chars[j] == '.') j++; // end is 'R'
            
            if (chars[i] == chars[j]) {
                Arrays.fill(chars, i, j, chars[i]);
            } else if (chars[i] == 'R' && chars[j] == 'L') {
                // odd and even; left part
                int middle = (j-i-1)/2;
                Arrays.fill(chars, i, i+middle+1, chars[i]);
                Arrays.fill(chars, j-middle, j+1, chars[j]);
            }
            
            i = j;
        }
        return String.copyValueOf(chars, 1, n-2);
    }
}

// X X X X X X 
//  [     ]
// L ... R => L ... R
// L ... L =>  LLLLL
// R _ R  => RRR
// R....R => RRRLLL  or RR.LL

/*public String pushDominoes(String d) {
        d = 'L' + d + 'R';
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 1; j < d.length(); ++j) {
            if (d.charAt(j) == '.') continue;
            int middle = j - i - 1;
            if (i > 0)
                res.append(d.charAt(i));
            if (d.charAt(i) == d.charAt(j))
                for (int k = 0; k < middle; k++)
                    res.append(d.charAt(i));
            else if (d.charAt(i) == 'L' && d.charAt(j) == 'R')
                for (int k = 0; k < middle; k++)
                    res.append('.');
            else {
                for (int k = 0; k < middle / 2; k++)
                    res.append('R');
                if (middle % 2 == 1)
                    res.append('.');
                for (int k = 0; k < middle / 2; k++)
                    res.append('L');
            }
            i = j;
        }
        return res.toString();
    }*/
