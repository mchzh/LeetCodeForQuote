class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int m = rowSum.size(), n = colSum.size();
        vector<vector<int>>rets(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = min(rowSum[i], colSum[j]);
                rets[i][j] = v;
                rowSum[i] -= v;
                colSum[j] -= v;
            }
        }
        return rets;
    }
};

/*class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int m=rowSum.size(),n=colSum.size();
        vector<vector<int>> res(m,vector<int>(n,0));
        
        for(int i=0,j=0;i<m&&j<n;){
            if(rowSum[i]<colSum[j]){
                res[i][j]=rowSum[i];
                colSum[j]-=rowSum[i];
                i++;
            }
            else if(rowSum[i]>colSum[j]){
                res[i][j]=colSum[j];
                rowSum[i]-=colSum[j];
                j++;
            }
            else {
                res[i][j]=colSum[j];
                i++;
                j++;
            }
        }
        
        return res;
    }
};*/
