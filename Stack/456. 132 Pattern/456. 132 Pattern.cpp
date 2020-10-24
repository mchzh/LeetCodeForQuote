class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int n = nums.size();
        if (n < 3) return false;
        vector<int>leftMin(n, INT_MAX);
        for (int i = 1; i < n; i++) {
            leftMin[i] = min(nums[i-1], leftMin[i-1]);
        }
        // second step using monotonica stack
        stack<int>s;
        for (int i = n-1; i >= 0; i--) {
            int second = INT_MIN;
            while (!s.empty() && s.top() < nums[i]) {
                second = s.top();
                s.pop();
            }
            if (second > leftMin[i]) return true;
            s.push(nums[i]);
        }
        return false;
    }
};

// 13  2
//     i j k
//     1 3 2
    
//     X
//           X   
// X
// i   j j+1...k
//     O(n2)
    
// O(n)
//     scan from right to left
    
//                            X
    
