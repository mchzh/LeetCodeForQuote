using LL = long long;
class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        int n = stations.size();
        LL left = 0, right = LLONG_MAX;
        while (left < right) {
            LL mid = right - (right - left) / 2;

            if (isOK(stations, r, k, mid)) {
                left = mid;
            } else {
                right = mid -1;
            }
        }
        return left;
    }

    bool isOK(vector<int> stations, int r, LL k, LL mid) {
        int n = stations.size();
        LL sum = 0;
        for (int i = 0; i <= r-1; i++) sum += stations[i];

        for (int i = 0; i < n; i++) {
            // slide the window to right 1 postion and out left 1 position
            if (i+r < n) 
                sum += stations[i+r];
            if (i-r-1 >= 0) sum -= stations[i-r-1];

            if (sum >= mid) continue;
            
                LL d = mid - sum;
                if (k < d) return false;
                stations[min(n-1, i+r)] += d;
                k -= d;
                sum += d;
            

        }
        return true;
    }
};
