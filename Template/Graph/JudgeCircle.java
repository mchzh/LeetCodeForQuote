import java.util.HashMap;
import java.util.*;

public class JudgeCircle {
    public static void main(String[] args) {
        int[][] edges1 = {{1, 0}};
        ToplogicalSort t1 = new ToplogicalSort(2, edges1);
        System.out.println(t1.isCircle(1) + " : compare : " + t1.isCircle(0));

        int[][] edges2 = {{1, 0}, {0, 1}};
        ToplogicalSort t2 = new ToplogicalSort(2, edges2);
        System.out.println(t2.isCircle(1) + " : compare : " + t2.isCircle(0));
    }

}
class ToplogicalSort {
    Map<Integer, List<Integer>> graph;
    int[] visited;
    int numNodes;

    public ToplogicalSort(int num, int[][] edges) {
        graph = new HashMap<>();
        visited = new int[num];
        this.numNodes = num;
        // create graph
        for (int i = 0; i < edges.length; i++) {
            graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
    }

    public boolean isCircle(int isDfs) {
        if (isDfs == 1) {
            for (int i = 0; i < numNodes; i++) {
                if (dfs(i) == false) return false;
            }
            return true;
        } else {
            return bfs();
        }
    }

    private boolean dfs(int cur) {
        if (visited[cur] == 1) return true;

        visited[cur] = 2;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (visited[next] == 1) continue;
                if (visited[next] == 2) return false;
                if (dfs(next) == false) return false;
            }
        }

        visited[cur] = 1;
        return true;
    }

    private boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        int[] indegree = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            if (!graph.containsKey(i)) continue;
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }

        // bfs
        for (int i = 0; i < numNodes; i++) {
            if (indegree[i]== 0) {
                q.offer(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!graph.containsKey(cur)) continue;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                    count++;
                }
            }
        }
        return count == numNodes;
    }
}
