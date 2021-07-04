class Solution {
    // https://leetcode.com/problems/number-of-atoms/solution/
    public String countOfAtoms(String formula) {
        // recrusion 
        // iterative with stack which element is a map
        // stack to parse string:
        // 1. encounter ( to push current calculated data into stack;
        // 2. encounter ) to get current data then combine with stack top element
        // 3. encounter other to calculate current visited element value
        int n = formula.length();
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        TreeMap<String, Integer> cur = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                // push previous map to stack
                stack.push(new TreeMap<>(cur));
                cur.clear();
            } else if (c == ')') {
                // get visited data and combine with top element of stack
                // get the followed number
                int j = i+1;
                while (j < n && Character.isDigit(formula.charAt(j))) j++;
                
                int num = 0;
                if (j == i+1) {
                    num = 1;
                } else {
                    num = Integer.valueOf(formula.substring(i+1, j));
                }
                for (String k : cur.keySet()) {
                    int newval = cur.get(k)*num;
                    cur.put(k, newval);
                }
                
                // combine top data
                Map<String, Integer> combine = stack.pop();
                for (String add : combine.keySet()) {
                    cur.put(add, cur.getOrDefault(add, 0) + combine.get(add));
                }
                
                i = j-1;
            } else if (Character.isUpperCase(c)) {
                // get element and its number
                // 1. get element name; 2. get the number of this element
                int j = i+1;
                while (j < n && Character.isLowerCase(formula.charAt(j))) j++;
                String elename = formula.substring(i, j);
                i = j;
                while (j < n && Character.isDigit(formula.charAt(j))) j++;
                
                int num = 0;
                if (j == i) {
                    num = 1;
                } else {
                    num = Integer.valueOf(formula.substring(i, j));
                }
                cur.put(elename, cur.getOrDefault(elename, 0)+num);
                i = j-1;
            }
        }
        
        // handle the map value to string;
        String rets = "";
        for (String k : cur.keySet()) {
            int count = cur.get(k);
            rets += (k + (count > 1 ? String.valueOf(count) : ""));
        }
        return rets;
    }
}
