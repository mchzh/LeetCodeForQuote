class Solution {
public:
    // to check how to generate gray code and reverse to get i
    int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        string str = bitset<32>(n).to_string();
        int i = 0;
        while (i < str.size() && str[i] == '0') i++;
        
        str = str.substr(i);
        i = 0;
        int lastDigits = 0;
        for (int k = 0; k < str.size(); k++) {
            int x;
            if (str[k] == '1') {
                x = lastDigits == 0 ? 1 : 0;
            } else {
                x = lastDigits == 0 ? 0 : 1;
            }
            
            i = i*2 + x;
            lastDigits = x;
        }
        
        return i;
    }
};

// 000,001,011,010,||110,111,101,100
    
// n = i^(i>>1)
// to get i: abcdef
//     abcdef
//     0abcde  (lastDigits)
//    -------
//     1^a^b
//     a b c
