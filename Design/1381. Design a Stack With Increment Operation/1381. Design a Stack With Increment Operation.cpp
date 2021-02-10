class CustomStack {
    vector<int>nums;
    vector<int>offset;
    int maxSize;
    int count = 0;
    int diff = 0;
public:
    CustomStack(int maxSize) {
        this->maxSize = maxSize;
        nums.resize(maxSize, 0);
        offset.resize(maxSize, 0);
    }
    
    void push(int x) {
        if (count == maxSize) return;
        
        if (count > 0) offset[count-1] += diff;
        
        diff = 0;
        nums[count] = x;
        offset[count] = 0;
        count += 1;
    }
    
    int pop() {
        if (count == 0) return -1;
        
        diff += offset[count-1];
        //cout<<diff<<endl;
        return nums[--count] + diff;
    }
    
    void increment(int k, int val) {
        if (count == 0) return;
        offset[min(k-1, count-1)] += val;
    }
};

//       xxxxx y
//offset     3
// diff: 3 -> 0
