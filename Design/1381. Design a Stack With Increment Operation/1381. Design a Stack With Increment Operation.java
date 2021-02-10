class CustomStack {
    // lazy load

    int[] stackarray;
    int[] lazy;
    int pos;
    int size;
    public CustomStack(int maxSize) {
        stackarray = new int[maxSize];
        lazy = new int[1001];
        pos = 0;
        size = maxSize;
    }
    
    public void push(int x) {
        if (isFull()) return;
        stackarray[pos++] = x;
    }
    
    public int pop() {
        if (isEmpty()) return -1;
        if (lazy[pos-1] != 0) {
            int tmp = lazy[pos-1];
            if (pos-2 >= 0) lazy[pos-2] += tmp;
            lazy[pos-1] = 0;
            return stackarray[--pos]+tmp;
        } else {
            return stackarray[--pos];
        }
    }
    
    public void increment(int k, int val) {
        if (isEmpty()) return;
        if (k > pos) {
            lazy[pos-1] += val;
        } else {
            lazy[k-1] += val;
        }
        
    }
    private boolean isEmpty() { return pos == 0; }
    private boolean isFull() { return pos == size; }
}
