class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    // max heap and min heap
    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<Integer>((a,b) -> (b-a));
        min = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (max.isEmpty() && min.isEmpty()) {
            max.offer(num);
        } else {
            //System.out.println(max.peek());
            if (num <= max.peek()) {
                max.offer(num);
            } else {
                min.offer(num);
            }
        }
        if (min.size()-max.size() == 2) {
            max.offer(min.poll());
        } else if (max.size()-min.size() == 2) {
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        return max.size() == min.size() ? (max.peek() + min.peek())*1.0 /2 : (max.size() > min.size() ? max.peek() : min.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*class MedianFinder {
    
    PriorityQueue<Integer> low;
    
    PriorityQueue<Integer> high;

    public MedianFinder() {
        this.low = new PriorityQueue<>(Collections.reverseOrder());
        this.high = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        this.low.add(num);
        
        this.high.add(this.low.poll());
        
        
        if(this.low.size() < this.high.size()) {
            this.low.add(this.high.poll());
        }
    }
    
    public double findMedian() {
        return this.low.size() > this.high.size() ? this.low.peek() : ((double) this.low.peek() + this.high.peek()) * 0.5;
    }
}*/
