class RecentCounter {

    // two pointer issue
    int left;
    int right;
    List<Integer> list = new ArrayList<>();
    
    public RecentCounter() {
        left = 0;
        right = 0;
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        right++;
        while (list.get(left) < t-3000) {
            left++;
        }
        return right-left;
    }
}
