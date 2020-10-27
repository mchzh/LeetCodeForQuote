class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        
        int x = Integer.MAX_VALUE, y;
        // for max ; start from the smaller gap with first two
        if (stones[1]-stones[0] > stones[n-1]-stones[n-2]) 
            y = (stones[n-2]-stones[0] +1) - (n-1) -1 + 1; // space - stone , first filled gap, first move step
        else 
            y = (stones[n-1]-stones[1] +1) - (n-1) -1 + 1;
        
        // for min with slide window which has contain n size at least
        for (int i = 0; i < n; i++) {
            int j = i; // i, j is idx of stones
            while (j < n && stones[j]-stones[i]+1 < n) {
                j++;
            }
            if (j == n) continue;
            
            int temp;
            if (stones[j]-stones[i]+1 == n) {
                temp = stones[j]-stones[i]+1 - (j-i+1);
            } else { // general case
                if ( (j-1)-i+1 == n-1 ) temp = 2;
                else temp = n-(j-i); // how many stones need to be filled
            }
            x = Math.min(x, temp);
        }
        return new int[] {x, y};
    }
}

// O X X X O X X O X O
// left right
// X X X X O O O O X X
//       i     j
// max:

// O OO . O . OOO. O  O
//  OOO . O . OOO. O  O
 
// min:

//                  i         j
// O   OO . O .OO . OOO . O   O O
//                  OOOOOOOOO
//                  OOOOOOOO  O
//                  OOOOOOOOO (n stone)
//                   OOOOOOO OO
//                   OOOOOOOOO
