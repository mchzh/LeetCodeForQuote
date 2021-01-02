class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        vector<int>p;
        for (int i = 0;i < nums.size(); i++) {
            if (nums[i] == 1) p.push_back(i);
        }
        
        // first slide window
        int sum = 0;
        for (int i = 0; i < k ; i++) {
            sum += abs(p[i] - p[k/2]);
        }
        
        int rets = sum;
        
        for (int i = 0; i+k < p.size(); i++) {
            int mid = i+k/2;
            sum -= abs(p[mid]-p[i]);
            sum += abs(p[mid+1]-p[i+k]);
            sum += k/2 * (p[mid+1]-p[mid]);
            sum -= (k-1-k/2) * (p[mid+1]-p[mid]);
            rets = min(rets, sum);
        }
        
        //System.out.println(rets);
        int offset = 0;
        for (int i = 0; i < k; i++) {
            offset += abs(i-k/2);
        }
        
        return rets - offset;
    }
};
