class RecentCounter {
    int left;
    int right;
    vector<int>list;
public:
    RecentCounter() {
        left = 0;
        right = 0;
    }
    
    int ping(int t) {
        list.push_back(t);
        right++;
        while (list[left] < t-3000) {
            left++;
        }
        return right-left;
    }
};
