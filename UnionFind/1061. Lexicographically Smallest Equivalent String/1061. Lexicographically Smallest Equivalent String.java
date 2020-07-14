class Solution {
   /* Reflexivity: 'a' == 'a'
Symmetry: 'a' == 'b' implies 'b' == 'a'
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'*/ // these three rules mean union find
    // union find O(logn) time complexity
    int[] parent = new int[26];
    public String smallestEquivalentString(String A, String B, String S) {
        int len = A.length();
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        
        for ( int i = 0; i < len; i++ ) {
            union(A.charAt(i)-'a', B.charAt(i)-'a');
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append((char)(find(S.charAt(i)-'a') +'a') );
        }
        return sb.toString();
        
    }
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    
    private int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
}

/*class Solution {
    // Typical Union Find problem
    int[] parent = new int[26];
    public String smallestEquivalentString(String A, String B, String S) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < A.length(); i++) {
            int letterA = A.charAt(i) - 'a';
            int letterB = B.charAt(i) - 'a';
            union(letterA, letterB);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);
            int idx = letter - 'a';
            if (parent[idx] == idx) {
                sb.append(letter);
            } else {
                int root = idx;
                while (root != parent[root]) {
                    root = parent[root];
                }
                
                sb.append((char) ('a' + root));
            }
        }
        return sb.toString();
    }
    
    private int find(int p) {
        // Find the root of the component
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        
        // Compress the path leading back to the root.
        // Doing this operation is called "path compression"
        // and is what gives us amortized time complexity
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }
    
    private void union(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);
        
        if (root1 == root2) return;
        if (root1 < root2) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
    }
}*/
