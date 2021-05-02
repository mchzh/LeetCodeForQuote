class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            
        int day = 0;
        for (int i = 0; i < courses.length; i++) {
            if (day + courses[i][0] <= courses[i][1]) {
                day = day + courses[i][0];
                pq.offer(courses[i][0]);
            } else {
                // overlap
                pq.offer(courses[i][0]);
                day += courses[i][0];  
                day -= pq.poll();
            }
        }
        return pq.size();
    }
}
// +1 +0
// 1-----
// 2     ------------  
// 3     ------deadline
//  s                   e
// 4               ---------
