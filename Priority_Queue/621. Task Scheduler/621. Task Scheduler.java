class Solution {
    // frist greedy use max heap
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[256];
        for (char ch : tasks) {
            chars[ch]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> ( b- a ) );
        for (int i = 0; i < 256; i++) {
            if (chars[i] == 0) continue;
            pq.offer(chars[i]);
        }
        n++;
        
        int count = 0;
        while ( !pq.isEmpty() ) { // for every round to designate the count num of this level
            
            int loopTimes = Math.min(pq.size(), n);
            
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < loopTimes; i++) {
                int curTask = pq.poll();
                if (curTask-1 > 0) {
                    temp.add(curTask-1);
                }
            }
            for (int i = 0; i < temp.size(); i++) pq.offer(temp.get(i)); // non-empty data continue to add into pq
            // get the task num of this round
            if (pq.size() != 0) count += n;
            else count += loopTimes;
        }
        return count;
    }
}

// n = 2
// [A B C][A B D][A B C][A D E][A B C][D E A][B C D][E F]
// A A A A A A
// B B B B B
// C C C C
// D D D D
// E E E 
// F
// ->
// A A A A A 
// B B B B 
// C C C 
// D D D D
// E E E 
// F

// A A A A A
// B B B B
// X X X X
