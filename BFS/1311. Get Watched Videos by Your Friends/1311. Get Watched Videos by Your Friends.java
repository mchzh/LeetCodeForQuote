class Solution {
    // bfs to get the kth level freind then collect video with frenquecy using map
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visited[id] = true;
        
        Set<Integer> selectedFriend = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curPerson = queue.poll();
                for (int nextf : friends[curPerson]) {
                    if (visited[nextf] == true) continue;
                    queue.offer(nextf);
                    visited[nextf] = true;
                    if (step == level) {
                        selectedFriend.add(nextf);
                    }
                }
            }
            if (step == level) break;
        }
        
        // get watch video
        Map<String, Integer> freq = new HashMap<>();
        for (int key : selectedFriend) {
            for (String svideo : watchedVideos.get(key)) {
                freq.put(svideo, freq.getOrDefault(svideo, 0) + 1);
            }
        }
        // sort this map with list
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (String key : freq.keySet()) {
            list.add(new Pair(key, freq.get(key)));
        }
        Collections.sort(list, (a, b) -> {
            //freq same
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return a.getValue()- b.getValue();
            }
        } );
        List<String> ret = new ArrayList<>();
        for (Pair<String, Integer> ele : list) {
            ret.add(ele.getKey());
        }
        return ret;
    }
}
