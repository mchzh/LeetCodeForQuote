class Solution {
    // dfs
    int[] visited = new int[50001];
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length) return false;
        if (arr[start] == 0) return true;
        if (visited[start] == 1) return false;
        
        visited[start] = 1;
        if (canReach(arr, start+arr[start])) return true;
        if (canReach(arr, start-arr[start])) return true;
        
        return false;
    }
}

// X X X X X - 1

// X X X X X X
//   | -----|
