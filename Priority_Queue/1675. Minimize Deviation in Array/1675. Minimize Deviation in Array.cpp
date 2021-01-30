class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        multiset<int>Set;
        
        for (auto x : nums) {
            if (x%2 == 1) {
                Set.insert(x*2);
            } else {
                Set.insert(x);
            }
        }
        
        int rets = INT_MAX;
        while (true) {
            rets = min(rets, *Set.rbegin()-*Set.begin());
            int m = *Set.rbegin();
            *Set.erase(Set.find(m));
            if (m%2 ==0) {
                Set.insert(m/2);
            } else {
                break;
            }
        }
        return rets;
    }
};
