import java.util.*;

class Solution {
    List<int[]>[] adj;
    int answer = 0;
    public int solution(int n, int infection, int[][] edges, int k) {
        adj = new ArrayList[n+1];
        boolean[] infected = new boolean[n+1];
        infected[infection] = true;
        
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edges.length; i++){
            adj[edges[i][0]].add(new int[] {edges[i][1], edges[i][2]});
            adj[edges[i][1]].add(new int[] {edges[i][0], edges[i][2]});
        }
        
        dfs(n, infected, 0, k);
        
        return answer;
    }
    
    public void dfs(int n, boolean[] infected, int depth, int k){
        if(depth == k){
            int cnt = 0;
            for(int i=1; i<=n; i++){
                if(infected[i]==true) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int type=1; type<4; type++){
            boolean[] next = infected.clone();
            
            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n; i++){
                if(next[i]) q.add(i);
            }
            
            while(!q.isEmpty()){
                int infectedNode = q.poll();
                for(int[] node : adj[infectedNode]){
                    if(!next[node[0]] && type==node[1]){
                        q.add(node[0]);
                        next[node[0]] = true;
                    }
                }
            }
            
            dfs(n, next, depth+1, k);
        }
    }
}