class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (heights[i] <= heights[i-1]) continue;
            pq.offer(heights[i]-heights[i-1]);
            if (pq.size() > ladders) {
                if (bricks < pq.peek()) return i-1;
                else bricks -= pq.poll();
            }
        }
        return n-1;
    }
}
// ladder = 6
    
// X X X B X X X | Y Y Y Y
// select the gap least building, and after select, it will not impact the later
// B X X B X X X Y | Y Y Y
