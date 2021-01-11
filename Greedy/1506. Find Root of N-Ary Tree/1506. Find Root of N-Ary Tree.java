/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /*  把每个节点及其直接连接的子节点的值进行异或，题目说值无重复
这样根节点只运算了1次，其余节点运算了2次（异或偶数次抵消了）
最后遍历所有的节点，找到 val 等于异或值的就是根节点*/
    // O(N) : find indegree is zero
    public Node findRoot(List<Node> tree) {
        // XOR solution
        // this is a DAG
        int rets = 0;
        
        // if it is children, add it into set
        for (Node n : tree) {
            rets ^= n.val;
            for (Node c : n.children) {
                rets ^= c.val;
            }
        }
        
        // check which one is not in this set
        
        for (Node n : tree) {
            if (rets == n.val) return n;
        }
        return null;
        //return rets;
    }
    public Node findRootWithSpace(List<Node> tree) {
        // XOR solution
        // this is a DAG
        Set<Integer> set = new HashSet<>();
        
        // if it is children, add it into set
        for (Node n : tree) {
            for (Node c : n.children) {
                set.add(c.val);
            }
        }
        
        // check which one is not in this set
        Node rets = null;
        for (Node n : tree) {
            if (!set.contains(n.val)) {
                rets = n;
                break;
            }
        }
        return rets;
    }
}
