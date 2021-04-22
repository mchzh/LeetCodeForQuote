class Solution {
    // words permutation
    // use trie or map to save the prefix
    List<List<String>> rets;
    int n;
    Map<String, Set<String>> map;
    public List<List<String>> wordSquares(String[] words) {
        n = words[0].length();
        // create the prefix map -> prefix : collection of word
        rets = new ArrayList<>();
        map = new HashMap<>();
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                map.computeIfAbsent(w.substring(0, i), k -> new HashSet<>()).add(w);
            }
        }
        List<String> square = new ArrayList<>();
        dfs(0, square);
        return rets;
    }
    private void dfs(int row, List<String> square) {
        if (row == n) {
            rets.add(new ArrayList<>(square));
            return;
        }
        String pre = "";
        for (int i = 0; i < row; i++) {
            pre += square.get(i).charAt(row);
        }
        if (!map.containsKey(pre)) return;
        for (String str : map.get(pre)) {
            square.add(str);
            dfs(row+1, square);
            square.remove(square.size()-1);
        }
    }
}

// ball
// aXXX
// l
// l

// for the i-th row, find the word whose prefix[0:i-1] = square[0:i-1][i]
