import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        List<List<Integer>> adj = new LinkedList<>();
        
        for(int i=0; i<n+1; i++){
            adj.add(new LinkedList<>());
        }
        
        for(int i=0; i<wires.length; i++){
            adj.get(wires[i][0]).add(wires[i][1]);
            adj.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i=0; i<wires.length; i++){
            adj.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            adj.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            dfs(n, adj);
            adj.get(wires[i][0]).add(wires[i][1]);
            adj.get(wires[i][1]).add(wires[i][0]);
        }
        
        return answer;
    }
    
    public void dfs(int nodeNum, List<List<Integer>> adj){
        boolean[] visited = new boolean[nodeNum+1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        
        visited[1]=true;
        q.add(1);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int n : adj.get(cur)){
                if(visited[n]) continue;
                visited[n] = true;
                cnt++;
                q.add(n);
            }
        }
        
        answer = Math.min(answer, Math.abs(2*cnt-nodeNum));
    }
}