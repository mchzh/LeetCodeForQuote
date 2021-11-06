class Solution {
    Set<Long> visited;
    public boolean possiblyEquals(String s1, String s2) {
        // dfs + memo
        visited = new HashSet<>();
        List<String> t1 = parse(s1);
        List<String> t2 = parse(s2);
        //System.out.println(t1.size() + " " + t2.size());
        
        return dfs(t1, 0, 0, t2, 0, 0);
    }
    
    private boolean dfs(List<String> t1, int i, int m1, List<String> t2, int j, int m2) {
        //System.out.println("begin -> " + t1.size() + " " + i + " "  + t2.size() + " " + j + " " + m2);
        // exit condition
        if (i == t1.size() && j == t2.size()) return m1 == m2;
        if (i == t1.size() && m1 == 0) return false;
        if (j == t2.size() && m2 == 0) return false;
        
        //System.out.println(t1.size() + " " + t2.size() + " " + j);
        long hash = (long)((long)i*1e10 + (long)m1*1e8 + (long)j*1e6 + (long)m2*1e4);
        if (visited.contains(hash)) return false;
        
        if (i < t1.size() && Character.isDigit(t1.get(i).charAt(0))) {
            //System.out.println(cur1);
            String cur1 = t1.get(i);
            Set<Integer> set1 = getNum(cur1);
            for (int x : set1) {
                if (dfs(t1, i+1, x+m1, t2, j, m2)) return true;
            }
            visited.add(hash);
            return false;
        } else if (j < t2.size() && Character.isDigit(t2.get(j).charAt(0))) {
            String cur2 = t2.get(j);
            //System.out.println(cur2);
            Set<Integer> set2 = getNum(cur2);
            for (int x : set2) {
                if (dfs(t1, i, m1, t2, j+1, x+m2)) return true;
            }
            visited.add(hash);
            return false;
        }
        
        // conquer
        if (m1 != 0 && m2 != 0) {
            int common = Math.min(m1, m2);
            return dfs(t1, i, m1-common, t2, j, m2-common);
        } else if (m1 != 0 && m2 == 0) {
            return dfs(t1, i, m1-1, t2, j+1, 0);
        } else if (m1 == 0 && m2 != 0) {
            return dfs(t1, i+1, 0, t2, j, m2-1);
        } else {
            if (t1.get(i).equals(t2.get(j))) return dfs(t1, i+1, 0, t2, j+1, 0);
            else {
                visited.add(hash);
                return false;
            }
        }
    }
    
    private Set<Integer> getNum(String str) {
        //System.out.println(str);
        int con = Integer.valueOf(str);
        Set<Integer> set = new HashSet<>();
        int len = str.length();
        set.add(con);
        if (len == 2) {
            set.add(con/10 + con%10);
        } else if (len == 3) {
            set.add(con/10 + con%10);
            set.add(con/100 + con%100);
            int single = con/100;
            con%= 100;
            set.add(single + con/10 + con%10);
        }
        
        return set;
    }
    
    private List<String> parse(String str) {
        List<String> rets = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                rets.add(String.valueOf(c));
            } else {
                int j = i;
                while (j <n && Character.isDigit(str.charAt(j))) j++;
                rets.add(str.substring(i, j));
                i = j-1;
            }
        }
        return rets;
    }
}

// ab121p

// ab****p
// ab********************p
//    [ 21              ]
// ab***************p
//   [12          ]
// ab*******************************************************p
//   [121                                                  ]
    
// a37p
// a**************************p
// a********p

// for two every possible to compare, brute force comparesion will cost O(n2)
    

// further consideration:

// recursion for different situation

// 3ab2c
// 2aa3c

// 1. both matcher is digit, matcher = min(n1, n2) -> 1ab2c and 0aa3c
// 2. first is digit, second is char, match the cur char -> 0ab2c and 0a3c => 0b2c and 3c (recusion 1)
// 3. first is char, second is digit, match the first char -> 2c and 2c
// 4. both mathcer is char, to check whether s[i] == t[i]

// recursion and dfs
// "13""b""c""4" -> 13"b""c""4" 
    
// s1 = "123""b""13"c"
// s2 = "2""b""b"3"
    
// dfs(123"b""13"c", 2"b""b"3")
// dfs(24"b""13"c", 2"b""b"3")
// dfs(15"b""13"c", 2"b""b"3")
// dfs(6"b""13"c", 2"b""b"3")

// dfs(0"b""13"c", 0"b""b"3")
