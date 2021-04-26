class Solution {
public:
    bool isNumber(string s) {
        while (s.size() > 0 && s.back() == ' ') s.pop_back();
        while (s.size() > 0 && s[0] == ' ') s.erase(s.begin());
        if (s == "") return false; // remove the front and rear spcace
        
        // get e count
        int counte = 0;
        int posE = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'e' || s[i] == 'E') {
                counte++;
                posE = i;
            }
        }
        if (counte > 1) return false;
        else if (counte == 0) return isOk(s, 1);
        else return isOk(s.substr(0, posE), 1) && isOk(s.substr(posE+1), 0); // left and right of E
    }
    bool isOk(string str, int k) {
        // sign
        
        int n = str.size();
        for (int i = 0; i < n; i++) {
            if ( (str[i] == '+' || str[i] == '-') && i != 0 ) return false;
        }
        if (str[0] == '+' || str[0] == '-') str.erase(str.begin());
        if (str == "" || str == ".") return false;
        
        int countdot = 0;
        for (int i = 0; i < str.size(); i++) {
            if (str[i] == '.') countdot++;
            else {
                if (!isdigit(str[i])) return false;
            }
        }
        return countdot <= k;
    }
};
