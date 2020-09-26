class Solution {
public:
    string reverseParentheses(string s) {
        string ret;
        stack<int>stack;
        int n = s.size();
        vector<int>pair(n, -1);
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                stack.push(i);
            } else if (s[i] == ')') {
                int j = stack.top();
                stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        // one pointer
        int i = 0;
        int d = 1;
        while (i < n) {
            if (isalpha(s[i])) {
                ret.push_back(s[i]);
            } else {
                i = pair[i];
                d = -d;
            }
            i += d;
        }
        return ret;
    }
};

//O(N)
// O(n2): reverse

// ret: abckghifed X

// abc(def(ghi)k) X

// 1. enter a parentheses pair: -> ( ,  ) <-;
//     goto the opposite one, flip direction;
// 2. exit a parentheses pair: -> ),  ( <-;
//     goto the opposite one, flip direction;                                
