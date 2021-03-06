class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        int N = num_people;
        int C = candies;
        
        // first step, ensure these candies support how many the whole rounds for every person
        int k = 0;
        while (C >= N*(N+1)/2 + N*N*k) {
            C -= N*(N+1)/2 + N*N*k;
            k++;
        }
        
        // sencodn step, for every person sum the first k rounds numbers 
        vector<int>ret(N, 0);
        if (k > 0) {
            for (int i = 0; i < N; i++)
                ret[i] += (i+1 + (k-1) * N + i+1) * k /2;
        }
        
        // last step, handle the rest of candies
        int idx = 0;
        while (idx < N) {
            if (C >= idx+1 + k*N) {
                ret[idx] += idx+1 + k*N;
                C -= idx+1 + k*N;
            } else {
                ret[idx] += C;
                break;
            }
            idx++;
        }
        return ret;
    }
};
