class FreqStack {
    unordered_map<int, vector<int>> freq2nums;
    unordered_map<int, int> count;
    int maxFreq = 0;
public:
    FreqStack() {
        
    }
    
    void push(int x) {
        int freq = count[x];
        freq2nums[freq+1].push_back(x);
        
        count[x] += 1;
        maxFreq = max(maxFreq, freq+1);
    }
    
    int pop() {
        int x = freq2nums[maxFreq].back();
        int freq = count[x];
        freq2nums[freq].pop_back();
        count[x] -= 1;
        if (freq2nums[maxFreq].size() == 0) maxFreq -= 1;
        return x;
    }
};
