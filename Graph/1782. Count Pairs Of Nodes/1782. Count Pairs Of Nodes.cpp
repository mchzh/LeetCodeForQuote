class Solution {
    long M = 20005;
public:
    vector<int> countPairs(int n, vector<vector<int>>& edges, vector<int>& queries) {
        vector<int>count(n);
        unordered_map<long, int>edgeCount;
        for (auto edge : edges) {
            int a = min(edge[0]-1, edge[1]-1);
            int b = max(edge[0]-1, edge[1]-1);
            count[a]++;
            count[b]++;
            edgeCount[a*M+b]++;
        }
        
        // sort
        vector<int>rets;
        auto count2 = count;
        sort(count2.begin(), count2.end());
        for (int x : queries) {
            int sum = 0;
            int j = n-1;
            for (int i = 0; i < n ; i++) {
                if (i >= j) {
                    sum += n-i-1;
                } else {
                    while (i < j && count2[i] + count2[j] > x) j--;
                    sum += n-j-1;
                }
            }
            
            for (auto [edgeIdx, cnt] : edgeCount) {
                int a = edgeIdx/M;
                int b = edgeIdx%M;
                if (count[a] + count[b] > x && count[a] + count[b] - cnt <= x) sum -= 1;
            }
            rets.push_back(sum);
        }
        return rets;
    }
};

// {a, b} a<b
// count[a] + count[b] - num[a->b] > x
// count0 => {} s.t. count[a] + count[b] > x  -> sort and two pointer
// offset => {} s.t. count[a] + count[b] > x && count[a] + count[b] - num[a->b] > x  | adjacent edge

// ret : count0 - offset

// count0: X X X X X X X X X X X
//         i         j
