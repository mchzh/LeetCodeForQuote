class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        sort(position.begin(), position.end());
        int left = 1, right = position.back() - position.front();
        while (left < right) {
            int mid = right - (right-left)/2;
            if (isOk(mid, position, m)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
    bool isOk(int d, vector<int>& position, int m) {
        int count = 1;
        for (int i = 0; i < position.size();) {
            int j = i;
            while (j < position.size() && position[j] - position[i] < d) j++;
            if (j == position.size()) break;
            else {
                count++;
            }
            if (count == m) return true;
            i = j;
        }
        return false;
    }
};
