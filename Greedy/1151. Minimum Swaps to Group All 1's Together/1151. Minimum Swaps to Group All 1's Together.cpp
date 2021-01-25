class Solution {
public:
    int minSwaps(vector<int>& data) {
        int n = data.size();
        vector<int>countzero(n+1, 0);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] == 0) count++;
            countzero[i+1] = count;
        }
        int size = n-count;
        //System.out.println(size + " " + count);
        int rets = INT_MAX;
        for (int i = size-1; i < n; i++) {
            rets = min(rets, countzero[i+1] - countzero[i+1-size]);
        }
        return rets;
    }
};
