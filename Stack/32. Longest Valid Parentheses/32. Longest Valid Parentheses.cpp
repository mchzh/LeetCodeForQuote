class Solution {
public:
    int longestValidParentheses(string s) {
        // stack to save index;
        int ret = 0;
        //if (s == NULL || s.size() == 0) return ret;
        stack<int>Stack;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') Stack.push(i);
            else {
                if (!Stack.empty() && s[Stack.top()] == '(') {
                    Stack.pop();
                    int len = Stack.empty() ? i-(-1) : i-Stack.top();
                    ret = max(ret, len);
                } else {
                    Stack.push(i);
                }
            }
        }
        return ret;
    }
};
