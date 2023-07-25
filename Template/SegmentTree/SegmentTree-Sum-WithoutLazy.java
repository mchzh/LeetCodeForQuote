class SegTreeNode {
        SegTreeNode left;
        SegTreeNode right;
        int info;
        int start, end;
        
        public SegTreeNode(int a, int b, int val) {
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
                info = left.info + right.info;  // check with your own logic
            }        
        }

        public SegTreeNode(int a, int b, int[] vals) {
            this.start = a;
            this.end = b;
            if (start == end) {
                info = vals[a];
                System.out.println(info + " " + start + " " + end);
                return;
            }
            int mid = (start+end)/2;
             if (left==null)
             {
                left = new SegTreeNode(start, mid, vals);
                right = new SegTreeNode(mid+1, end, vals);            
                info = left.info + right.info;  // check with your own logic
            }  
        }

        public int queryRange(int a, int b) { // query the sum over range [a,b]
            if (b < start || a > end) {
                return 0; // write your logic
            }
            if (a <= start && b >= end) {
                return info;
            }
        
            int leftUpdate = left.queryRange(a, b); // get left sum
            int rightUpdate = right.queryRange(a, b); // get right sum
            info = left.info + right.info; // update current info

            return leftUpdate + rightUpdate;
        }

        public void updateSingle(int index, int val) {
            if (index < start || index > end) return;
            if (start == end) {
                info = val;
                return;
            }
            left.updateSingle(index, val);
            right.updateSingle(index, val);
            info = left.info + right.info;
        }
    }
