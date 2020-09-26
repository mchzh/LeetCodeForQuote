class Solution {
public:
    int checkRecord(int n) {
        int mod = 1e9+7;
        vector<long>dp00(n+1, 0);
        vector<long>dp01(n+1, 0);
        vector<long>dp02(n+1, 0);
        vector<long>dp10(n+1, 0);
        vector<long>dp11(n+1, 0);
        vector<long>dp12(n+1, 0);
        dp00[0] = 1;
        
        for (int i = 1; i <=n ; i++) {
            dp00[i] = (dp00[i-1] + dp01[i-1] + dp02[i-1]) % mod;
            dp01[i] = dp00[i-1] % mod;
            dp02[i] = dp01[i-1] % mod;
            dp10[i] = (dp00[i-1] + dp01[i-1] + dp02[i-1] + dp10[i-1] + dp11[i-1] + dp12[i-1]) % mod;
            dp11[i] = dp10[i-1] % mod;
            dp12[i] = dp11[i-1] % mod;
        }

        return (dp00[n] + dp01[n] + dp02[n] + dp10[n] + dp11[n] + dp12[n])%mod;

    }
};

// dp00[i]: for S[0..i] never A apperance, ending with 0 L
// dp01[i]: for S[0..i] never A apperance, ending with 1 L
// dp02[i]: for S[0..i] never A apperance, ending with 2 L
// dp10[i]: for S[0..i] only one A apperance, ending with 0 L
// dp11[i]: for S[0..i] only one A apperance, ending with 1 L
// dp12[i]: for S[0..i] only one A apperance, ending with 2 L

// dp00[0]= 1;
// dp01[0]= 0;
// dp02[0]= 0;
// dp10[0]= 0;
// dp11[0]= 0;
// dp12[0]= 0;

// for (int i = 1; i <=n ; i++) {
//     dp00[i] = dp00[i-1]*('P') + dp01[i-1]*('P') + dp02[i-1]*('P');
//     dp01[i] = dp00[i-1]*'L';
//     dp02[i] = dp01[i-1]*'L';
//     dp10[i] = dp00[i-1]*('A') + dp01[i-1]*('A') + dp02[i-1]*('A') + 
//                 dp10[i-1]*('P') + dp11[i-1]*('P') + dp12[i-1]*('P');
//     dp11[i] = dp10[i-1]*'L';
//     dp12[i] = dp11[i-1]*'L';
// }

// return dp00[n] + dp01[n] + dp02[n] + dp10[n] + dp11[n] + dp12[n];

  
// X X X X X X X X X
//         i-1 i
// ======================
// more than one 'A' (absent)
// dp0[i]: for S[0..i] never A apperance
// dp1[i]: for S[0..i] only one A apperance

// dp0[0]= 1;
// dp1[0]= 0;

// for (int i = 1; i <=n ; i++) {
//     dp0[i] = dp0[i-1]*2 ('L', 'P');
//     dp1[i] = dp0[i-1]*1('A') + dp1[i-1]*2('L', 'P');
// }

// return dp0[n] + dp1[n];
    
// ======================
// paint house : OOOXOOOO
// more than two continuous 'L':
// dp0[i]: for S[0..i] ending with 0 L
// dp1[i]: for S[0..i] ending with 1 L
// dp2[i]: for S[0..i] ending with 2 L

// dp0[0]= 1;
// dp1[0]= 0;
// dp2[0]= 0;

// for (int i = 1; i <=n ; i++) {
//     dp0[i] = (dp0[i-1]+dp1[i-1]+dp2[i-1])*('A', 'P');
//     dp1[i] = dp0[i-1]*'L';
//     dp2[i] = dp1[i-1]*'L';
// }

// return dp0[n] + dp1[n] + dp2[n];

