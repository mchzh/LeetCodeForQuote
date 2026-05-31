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
