import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<int[]>> adj = new LinkedList<>();
        for(int i=0; i<=N; i++){
            adj.add(new LinkedList<>());
        }
        
        for(int i=0; i<road.length; i++){
            adj.get(road[i][0]).add(new int[] {road[i][1], road[i][2]});
            adj.get(road[i][1]).add(new int[] {road[i][0], road[i][2]});
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int[] dp = new int[N+1];
        for(int i=2; i<=N; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int[] node : adj.get(1)){
            q.add(new int[] {node[0], node[1]});
            dp[node[0]] = Math.min(dp[node[0]], node[1]);
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(dp[cur[0]]>cur[1]) continue;
            
            for(int[] node : adj.get(cur[0])){
                int distance = cur[1]+node[1];
                if(distance<=K && distance<dp[node[0]]){
                    dp[node[0]] = Math.min(dp[node[0]], cur[1]+node[1]);
                    q.add(new int[] {node[0], cur[1]+node[1]});
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dp[i]<=K) answer++;
        }
        
        return answer;
    }
}