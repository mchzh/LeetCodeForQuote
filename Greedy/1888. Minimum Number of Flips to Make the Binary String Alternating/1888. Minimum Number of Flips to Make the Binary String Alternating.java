class Solution {
    public int minFlips(String s) {
        int rets = Integer.MAX_VALUE;
        int n = s.length();
        // even pos : 1 and 0 number
        // odd pos: 1 and 0 number
        int evenOne = 0, evenZero = 0;
        for (int i = 0; i < n; i += 2) {
            char c = s.charAt(i);
            evenOne += (c == '1' ? 1 : 0);
            evenZero += (c == '0' ? 1 : 0);
        }
        int oddOne = 0, oddZero = 0;
        for (int i = 1; i < n; i += 2) {
            char c = s.charAt(i);
            oddOne += (c == '1' ? 1 : 0);
            oddZero += (c == '0' ? 1 : 0);
        }
        // two situation:
        // 1. even with one and odd with zero
        // 2. even with zero and odd with one
        // for 1. : (evenCount-evenZero) + (oddCount-oddOne)
        // for 2. : (evenCount-evenOne) + (oddCount-oddZero)
        int evenCount = 0, oddCount = 0;
        if (n%2 == 0) {
            evenCount = n/2;
            oddCount = n/2;
        } else {
            evenCount = n/2 + 1;
            oddCount = n/2;
        }
        int curMin = Math.min((evenCount-evenZero) + (oddCount-oddOne), (evenCount-evenOne) + (oddCount-oddZero));
        rets = Math.min(rets, curMin);
        //int evenCountSwap0 = evenCount, oddCountSwap0 = oddCount;
        //int evenCountSwap1 = oddCount, oddCountSwap1 = evenCount;
        if (n%2 == 1) {
            for (int i = 1; i < n; i++) {
                // swap evenCount and oddCount
                int temp = evenCount;
                evenCount = oddCount;
                oddCount = temp;
                // cal the update one and zero for even and odd
                int temp1 = evenOne;
                evenOne = oddOne;
                oddOne = temp1;
                int temp2 = evenZero;
                evenZero = oddZero;
                oddZero = temp2;
                char c = s.charAt(i-1);
                if (c == '0') {
                    evenZero += 1;
                    oddZero -= 1;
                } else {
                    evenOne += 1;
                    oddOne -= 1;
                }
                int rotateMin = Math.min((evenCount-evenZero) + (oddCount-oddOne), (evenCount-evenOne) + (oddCount-oddZero));
                rets = Math.min(rets, rotateMin);
            }
        }
        
        return rets;
    }
}
