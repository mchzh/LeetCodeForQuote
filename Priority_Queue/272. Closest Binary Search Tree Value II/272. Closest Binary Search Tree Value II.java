class Solution {
    // sort and heap or quick select
    //https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> rets = new ArrayList<>();
        if (root == null) return rets;
        
        Stack<Integer> stackpre = new Stack<>();
        Stack<Integer> stacksuc = new Stack<>();
        
        inorder(root, target, false, stackpre);
        inorder(root, target, true, stacksuc);
        // while () {
        //     System.out.println(stackpre.peek());
        // }
        
        while (k-- >0) {
            if (stackpre.isEmpty()) {
                //System.out.println("suc -> " + stacksuc.peek());
                rets.add(stacksuc.pop());
            } else if (stacksuc.isEmpty()) {
                //System.out.println("pre -> " + stackpre.peek());
                rets.add(stackpre.pop());
            } else if (Math.abs(stackpre.peek()-target) < Math.abs(stacksuc.peek()-target)) {
                //System.out.println(stackpre.peek() + " : " +stacksuc.peek());
                rets.add(stackpre.pop());
            } else {
                //System.out.println(stackpre.peek() + " : " +stacksuc.peek());
                rets.add(stacksuc.pop());
            }
        }
        return rets;
    }
    private void inorder(TreeNode node, double target, boolean isReverse, Stack<Integer> stack) {
        if (node == null) {
            return;
        }
        
        inorder(isReverse ? node.right : node.left, target, isReverse, stack);
        // handle current element
        if ( (!isReverse && node.val > target) || (isReverse && node.val <= target)) return;
        stack.push(node.val);
        inorder(isReverse ? node.left : node.right, target, isReverse, stack);
    }
}

/*class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                Double d1 = n1.sub;
                Double d2 = n2.sub;
                return d1.compareTo(d2);
            }
        });
        helper(root, pq, target);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().val);
        }
        return res;
    }
    public void helper(TreeNode root, PriorityQueue<Node> pq, double target) {
        if (root == null) return;
        pq.offer(new Node(root.val, target));
        helper(root.left, pq, target);
        helper(root.right, pq, target);
    }
    
    class Node {
        int val;
        double sub;
        double tar;
        public Node(int val, double tar) {
            this.val = val;
            this.tar = tar;
            this.sub = Math.abs(val-tar);
        }
    }
}*/
