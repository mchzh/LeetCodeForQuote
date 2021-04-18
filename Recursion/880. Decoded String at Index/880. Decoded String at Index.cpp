class Solution {
public:
    string decodeAtIndex(string S, int K) {
        long long count = 0;
        for (int i = 0; i < S.size(); i++) {
            char c = S[i];
            if (isalpha(c)) {
                count++;
                if (count == K) {
                    string ret;
                    ret.push_back(c);
                    return ret;
                }
            } else {
                int times = (c-'0');
                if (count*times < K) {
                    count = count*times;
                } else if (K%count == 0) {
                    return decodeAtIndex(S.substr(0, i+1), count);
                } else {
                    return decodeAtIndex(S.substr(0, i+1), K%count);
                }
            }
        }
        return "";
    }
};
