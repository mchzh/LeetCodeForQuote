class Solution {
    // /https://www.youtube.com/watch?v=UYNAJBiA1rk
    public boolean isPreorder(List<List<Integer>> nodes) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nodes.get(0).get(0));
        for (int i = 1; i < nodes.size(); i++) {
            List<Integer> cur = nodes.get(i);
            while (!stack.isEmpty() &&  (!cur.get(1).equals(stack.peek())) ) {
                // not find parent for cuurent node
                stack.pop();
            }
            if (stack.isEmpty()) return false;
            stack.push(cur.get(0));
        }
        return true;
    }
}
