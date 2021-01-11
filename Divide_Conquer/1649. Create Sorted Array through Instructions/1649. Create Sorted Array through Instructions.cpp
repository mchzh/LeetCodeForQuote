class Solution {
    long long smaller[100005];
    long long temp[100005];
    long long count[100005];
    long long sorted[100005];
    long long M = 1e9+7;
public:
    int createSortedArray(vector<int>& instructions) {
        int n = instructions.size();
        for (int i = 0; i < n; i++) {
            sorted[i] = instructions[i];
        }
        
        helper(instructions, 0, n-1);
        long long rets = 0;
        for (int i = 0; i < n; i++) {
            //System.out.println(smaller[i]);
            int cost = min(smaller[i], i-count[instructions[i]]-smaller[i]);
            rets = (rets+cost)%M;
            count[instructions[i]]++;
        }
        return rets;
    }
    
    void helper(vector<int>& instructions, int a, int b) {
        if (a >= b) return;
        int mid = a + (b-a)/2;
        // divide
        helper(instructions, a, mid);
        helper(instructions, mid+1, b);
        
        // conquer
        for (int i = mid+1; i <= b; i++) {
            auto iter = lower_bound(sorted+a, sorted+mid+1, instructions[i]);
            
            smaller[i] += iter-(sorted+a);
        }
        
        // merge sorted algorithm
        int i = a, j = mid+1, p = 0;
        while (i <= mid && j <= b) {
            if (sorted[i] <= sorted[j]) {
                temp[p] = sorted[i];
                i++;
            }else {
                temp[p] = sorted[j];
                j++;
            }
            p++;
        }
        while (i <= mid) {
            temp[p] = sorted[i];
            i++;
            p++;
        }
        while (j <= b) {
            temp[p] = sorted[j];
            j++;
            p++;
        }
        
        // set temp to sorted
        for (int k = 0; k < b-a+1; k++) {
            sorted[k+a] = temp[k];
        }
    }
};
