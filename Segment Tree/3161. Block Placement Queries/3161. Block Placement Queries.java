class Solution {
    public List<Boolean> getResults(int[][] queries) {
        //int n = queries.length;
        int n = Math.min(50000, (int)queries.length*3) + 5;
        SegTreeNode root = new SegTreeNode(0, n, 0);
        System.out.println(root.queryRange(0, 2));
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        List<Boolean> lists = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                // type1 : set block
                // find prev one and next one
                int x = q[1];
                set.add(x);
                int a = set.lower(x);
                //System.out.println("add block -> " + x + " : "  + a);
                root.updateRange(x, x, x-a);

                if (set.higher(x) != null) {
                    int b = set.higher(x);
                    //System.out.println(b);
                    root.updateRange(b, b, b-x);
                }
            } else {
                // type 2: query max
                int x = q[1], sz = q[2];
                int curlen = root.queryRange(0, x);
                //System.out.println(curlen + " : " + x);

                if (!set.contains(x)) {
                    int a = set.lower(x);
                    //System.out.println(a + " : " + curlen + " : " + x + " : " + sz);
                    curlen = Math.max(curlen, x-a);
                }
                //System.out.println("last -> " + curlen + " : " + sz);
                lists.add(curlen >= sz);
            }
        }
        //return lists.stream().mapToInt(i -> i).toArray();
        return lists;
    }
}
class SegTreeNode {
        SegTreeNode left;
        SegTreeNode right;
        int info;
        int start, end;
        boolean tag;
        
        public SegTreeNode(int a, int b, int val) {
            this.tag = false;
            this.start = a;
            this.end = b;
            if (start == end) {
                info = val;
                return;
            }
            int mid = (start+end)/2;
            if (left==null)
            {
                left = new SegTreeNode(start, mid, val);
                right = new SegTreeNode(mid+1, end, val);            
                info = Math.max(left.info, right.info);  // check with your own logic
            }        
        }

        public SegTreeNode(int a, int b, int[] vals) {
            this.tag = false;
            info = 0;
            this.start = a;
            this.end = b;
            if (start == end) {
                info = vals[a];
                //System.out.println(info + " " + start + " " + end);
                return;
            }
            int mid = (start+end)/2;
             if (left==null)
             {
                left = new SegTreeNode(start, mid, vals);
                right = new SegTreeNode(mid+1, end, vals);            
                info = Math.max(left.info, right.info);  // check with your own logic
            }  
        }

        private void pushDown()  // lazy tag
        {
            if (tag==true && left != null)
            {
                left.info = info;
                right.info = info;
                left.tag = true;
                right.tag = true;
                tag = false;
            }        
        } 

        public int queryRange(int a, int b) { // query the sum over range [a,b]
            if (b < start || a > end) {
                return Integer.MIN_VALUE/2; // write your logic
            }
            if (a <= start && b >= end) { //&& control
                return info;
            }

            if (left != null) {
                pushDown();
                int ret = Math.max(left.queryRange(a, b), right.queryRange(a, b));
                info = Math.max(left.info, right.info);
                return ret;
            }
        
            return info;
        }

        public void updateRange(int a, int b, int val) {       
            if (b < start || a > end) return; // not cover at all
            if (a <= start && b >= end) { // completely cover [a,b]
                info = val;
                tag = true;
                return;
            }
            
            if (left != null) {
                pushDown();
                left.updateRange(a, b, val);
                right.updateRange(a, b, val);
                info = Math.max(left.info, right.info);
            } 
        }
    }
