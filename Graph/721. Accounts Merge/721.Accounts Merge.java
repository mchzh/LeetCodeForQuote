class Solution {
    // dfs and union find - created Undirected graph
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> email = new HashMap<>(); // email -> email list
        Map<String, String> owner = new HashMap<>(); // email -> person
        for (List<String> a : accounts) {
            String name = a.get(0);
            int size = a.size();
            // create email graph
            String femail = a.get(1);
            owner.put(femail, name);
            if (size == 2) email.computeIfAbsent(femail, k -> new HashSet<>()).add(null);
            for (int i = 2; i < size; i++) {
                String firstemail = a.get(i-1);
                String secondemail = a.get(i);
                email.computeIfAbsent(firstemail, k -> new HashSet<>()).add(secondemail);
                email.computeIfAbsent(secondemail, k -> new HashSet<>()).add(firstemail);
                owner.put(secondemail, name);
            }
        }
        
        // bfs
        List<List<String>> rets = new ArrayList<>();
        
        Set<String> visited = new HashSet<>();
        for (String key : email.keySet()) {
            if (visited.contains(key)) continue;
            List<String> list = new ArrayList<>();
            dfs(key, list, email, visited);
            Collections.sort(list);
            list.add(0, owner.get(key));
            rets.add(list);
        }
        return rets;
    }
    private void dfs(String start, List<String> list, Map<String, Set<String>> email, Set<String> visited) {
        if (start == null || start.length() == 0) return;
        list.add(start);
        visited.add(start);
        for (String next : email.get(start)) {
            if (visited.contains(next)) continue;
            dfs(next, list, email, visited);
        }
    }
}

// mail ->  person 
// mail -> relation

// edge : diretc edge
// j@com -> i@com
