class MKAverage {

    Queue<Integer> q;
    List<Integer> list;
    int m;
    int k;
    long sum;
    public MKAverage(int m, int k) {
        q = new LinkedList<>();
        list = new ArrayList<>();
        this.m = m;
        this.k = k;
        sum = 0;
    }
    
    public void addElement(int num) {
        if (q.size() == m) {
            remove();
        }
        //System.out.println("before add new ele -> " + num + " " + min.peek() + " " + max.peek());
        int index = Collections.binarySearch(list, num);
        if (index < 0) index = -(index+1);
        // handle sum
        if (2*k <= list.size()) {
            if (index < k) {
                sum += list.get(k-1);
            } else if (index <= list.size()-k) {
                sum += num;
            } else {
                sum += list.get(list.size() -k);
            }
        }
        //System.out.println(num + " " + min.peek() + " " + max.peek()+ " " + min.size() + " " + max.size());
        list.add(index, num);
        q.offer(num);
    }
    
    private void remove() {
        int cur = q.poll();
        int index = Collections.binarySearch(list, cur);
        if (k*2+1 <= list.size()) {
            if (index < k) {
                sum -= list.get(k);
            } else if (index < list.size()-k) {
                sum -= cur;
            } else {
                sum -= list.get(list.size() -k-1);
            }
        }
        list.remove(index);
    }
    
    public int calculateMKAverage() {
        if (q.size() < m) return -1;
        return (int)(sum/(m-2*k));
    }
}
