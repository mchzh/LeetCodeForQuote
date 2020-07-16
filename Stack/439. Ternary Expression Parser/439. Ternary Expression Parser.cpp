class Solution {
    // what time push stack, and what time pop stack
public:
    string parseTernary(string expression) {
        stack<string>stack;
        string curStr;
        for (int i = 0; i < expression.size(); i++) {
            if (expression[i+1] == '?') {
                stack.push(curStr); // ensure stack not empty
                curStr = expression[i];
            } else {
                curStr += expression[i];
                while (curStr.size() == 5) {
                    curStr = eval(curStr);
                    curStr = stack.top() + curStr;
                    stack.pop();
                    /*if (!stack.empty()) {
                        curStr = eval(curStr);
                        curStr = stack.top() + curStr;
                        stack.pop();
                    }*/
                }
            }
        }
        return curStr;
    }
    string eval(string s) {
        string ret;
        if (s[0] == 'T')
            ret = s[2];
        else
            ret = s[4];
        return ret;
    }
};

// "?" , previous string push stack
// "b?x:Y" , standard pattern pop stack
// nest 
