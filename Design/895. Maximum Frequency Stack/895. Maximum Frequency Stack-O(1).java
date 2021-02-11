class FreqStack {

    Map<Integer, Integer> map; // key -> freq
    Map<Integer, Stack<Integer>> freq; // freq -> elements
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        int curFreq = map.get(x);
        maxFreq = Math.max(maxFreq, curFreq);
        freq.computeIfAbsent(curFreq, k -> new Stack<Integer>()).push(x);
    }
    
    public int pop() {
        while (maxFreq > 0 && freq.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        if (maxFreq == 0) {
            return -1;
        } else {
            int x = freq.get(maxFreq).pop();
            map.put(x, map.getOrDefault(x, 0) - 1);
            return x;
        }
    }
}
