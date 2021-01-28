class Solution {
public:
    int concatenatedBinary(int n) {
        long long ret = 1;
        long long M = 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            int len = log(i)/log(2) + 1;
            ret = (ret<<len|i) % M;
            ret %= M;
        }
        return ret;
    }
};

// n = 1: 1 => 1;
// n = 2: 1 10 => 1*2^2 + 2 = 6
// n = 3: 110 11 => 6*2^2 + 3 = 27

// ret[n] = ret[n-1]*2^len + n;
// len is how manay binary digit for n

// len = log(n)/log(2)
