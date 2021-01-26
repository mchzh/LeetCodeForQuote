class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int N = req_skills.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(req_skills[i], i);
        }
        // person skillset
        int[] p2s = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            List<String> cur = people.get(i);
            for (String s : cur) {
                if (map.containsKey(s)) {
                    p2s[i] |= (1<<map.get(s));
                }
            }
            //System.out.println(p2s[i] + " " + i);
        }
        
        int[] dp = new int[1<<N];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        
        List[] plist = new List[1<<N];
        for (int i = 0; i < (1<<N); i++) {
            plist[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < people.size(); i++) {
            int[] dp2 = Arrays.copyOf(dp, 1<<N);
            for (int skillset = 0; skillset < (1<<N); skillset++) {
                int newskillset = skillset | p2s[i];
                if (dp2[newskillset] > dp[skillset] + 1) {
                    dp2[newskillset] = dp[skillset] + 1;
                    plist[newskillset].clear();
                    plist[newskillset].addAll(plist[skillset]);
                    plist[newskillset].add(i);
                    //System.out.println(plist[newskillset].size() + " " + newskillset + " " + skillset);
                }
            }
            dp = Arrays.copyOf(dp2, 1<<N);
        }
        List<Integer> rets = new ArrayList<>(plist[(1<<N)-1]);
        return rets.stream()
					.map(i -> (i == null ? 0 : i))
					.mapToInt(Integer::intValue)
					.toArray();
					// Set<String> set = new HashSet<>();
					// for (String s : req_skills) {
					// set.add(s);
					// }
					// int n = people.size();
					// List<Integer> list = new ArrayList<>();
					// for (int i = 1; i < (1<<n); i++) {
					// isAllset(i, people, set, list);
					// }
					// return list.stream()
					// .map(i -> (i == null ? 0 : i))
					// .mapToInt(Integer::intValue)
					// .toArray();
    }
    private void isAllset(int cur, List<List<String>> people, Set<String> set, List<Integer> list) {
        Set<String> skillObsession = new HashSet<>();
        int count = 0;
        List<Integer> curlist = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ( ((cur>>i)&1) == 1) {
                for (String s : people.get(i)) {
                    if (set.contains(s)) {
                        skillObsession.add(s);
                    }
                }
                count++;
                curlist.add(i);
            }
        }
        if (skillObsession.size() == set.size()) {
            if (list == null || list.size() == 0 || count < list.size()) {
                list.clear();
                list.addAll(new ArrayList<Integer>(curlist));
            }
        }
        
    }
}

// for o
//   for capacity
//       dp[capacity] = dp[capacity-c(i)] + v[i];

// for people
//     for skillset
//        newskillset = skillset | peopleskillset;
//        dp[newskillset] = min(dp[newskillset], dp[skillset]+1);
