class Solution {
    vector<vector<string>> rets;
    int n;
    unordered_map<string, vector<string>>map;
public:
    vector<vector<string>> wordSquares(vector<string>& words) {
        this->n=words[0].size();
        for (auto w : words) {
            for (int i = 0; i < w.size(); i++) {
                map[w.substr(0, i)].push_back(w);
            }
        }
        vector<string>square;
        dfs(0, square);
        return rets;
    }
    void dfs(int row, vector<string>& square) {
        if (row == n) {
            rets.push_back(square);
            return;
        }
        string prefix;
        for (int i= 0; i < row; i++) {
            prefix.push_back(square[i][row]);
        }
        for (auto& word : map[prefix]) {
            square.push_back(word);
            dfs(row+1, square);
            square.pop_back();
        }
    }
};
