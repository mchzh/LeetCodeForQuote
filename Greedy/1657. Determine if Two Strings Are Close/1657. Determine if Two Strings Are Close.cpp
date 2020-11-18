class Solution {
public:
    bool closeStrings(string word1, string word2) {
        unordered_set<char>Set1;
        unordered_set<char>Set2;
        
        vector<int>count1(26);
        vector<int>count2(26);
        
        for (char c1 : word1) {
            Set1.insert(c1);
            count1[c1-'a']++;
        }
        
        for (char c2 : word2) {
            Set2.insert(c2);
            count2[c2-'a']++;
        }
        
        sort(count1.begin(), count1.end());
        sort(count2.begin(), count2.end());
        
        return Set1 == Set2 && count1 == count2;
    }
};

// 1. have the same char type;
// 2. have the same sorted frequency array;

// a b c
// 2 3 1
// 1 2 3
// 1 3 2
// 2 1 3
// 3 2 1
// 3 1 2
    
// a b c
// 2 3 1
// 1 2 3
// 1 3 2
// 2 1 3
// 3 2 1
// 3 1 2
