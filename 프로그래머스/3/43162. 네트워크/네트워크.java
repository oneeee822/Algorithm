import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1){
                    adj[i].add(j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, adj, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int nodeIdx, List<Integer>[] adj, int n){
        visited[nodeIdx] = true;
        for(int a : adj[nodeIdx]){
            if(!visited[a]) {
                dfs(a, adj, n);
            }
        }
    }
}