class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        const int mod = 1000000007;

        int r = pizza.size();
        int c = pizza[0].size();

        vector<vector<vector<int>>> f(k, vector<vector<int>>(r, vector<int>(c, 0)));
        vector<vector<int>> p(r + 1, vector<int>(c + 1, 0));

        for (int i = r - 1; i >= 0; i--)
            for (int j = c - 1; j >= 0; j--)
                p[i][j] = (int)(pizza[i][j] == 'A')
                    + p[i + 1][j] + p[i][j + 1] - p[i + 1][j + 1];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                f[0][i][j] = (int)(p[i][j] > 0);

        for (int l = 1; l < k; l++)
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++) {
                    for (int ti = i + 1; ti < r; ti++)
                        if (check(i, j, ti - 1, c - 1, p))
                            f[l][i][j] = (f[l][i][j] + f[l - 1][ti][j]) % mod;

                    for (int tj = j + 1; tj < c; tj++)
                        if (check(i, j, r - 1, tj - 1, p))
                            f[l][i][j] = (f[l][i][j] + f[l - 1][i][tj]) % mod;
                }

        return f[k - 1][0][0];
    }
    bool check(int x1, int y1, int x2, int y2, const vector<vector<int>>& p) {
        return p[x1][y1] - p[x2 + 1][y1] - p[x1][y2 + 1] + p[x2 + 1][y2 + 1] > 0;
    }
};
