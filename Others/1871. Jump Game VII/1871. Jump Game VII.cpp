class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.size();
        if (s.back() == '1') return false;
        vector<int> diff(n+1);
        diff[0+minJump] += 1;
        diff[0+maxJump+1] -= 1;
        
        int reach = 0;
        for (int i = 1; i < n; i++) {
            reach += diff[i];
            if (reach == 0) continue;
            if (s[i] == '1') continue;

            if (i+minJump < n) diff[i+minJump] += 1;
            if (i+maxJump < n) diff[i+maxJump+1] -= 1;
        }

        return reach;
    }
};
