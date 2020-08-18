class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]-a[0])); // max heap
        pq.offer(new int[] {A, 1});
        pq.offer(new int[] {B, 2});
        while ( !pq.isEmpty() ) {
            int size = pq.size();
            
            int[] cur1 = pq.poll();
            if (size == 1) {
                if (cur1[0] > 2) {
                    return "";
                } else {
                    for (int i = 0; i < cur1[0]; i++) {
                        sb.append(cur1[1] == 1 ? 'a' : 'b');
                    }
                    return sb.toString();
                }
            }
            
            
            int[] cur2 = pq.poll();
            int k = Math.min(2, 1+cur1[0]-cur2[0]);
            for (int i = 0; i < k; i++) {
                sb.append(cur1[1] == 1 ? 'a' : 'b');
                cur1[0]--;
            }
            sb.append(cur2[1] == 1 ? 'a' : 'b');
            cur2[0]--;
            if (cur1[0] > 0) pq.offer(cur1);
            if (cur2[0] > 0) pq.offer(cur2);
        }
        return sb.toString();
    }
}
// a> b
// a<b*2+2
// aabaababababababaa
