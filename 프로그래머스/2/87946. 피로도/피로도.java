import java.util.*;

class Solution {
    static boolean visited[];
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int cur, int[][] dungeons, int cnt){
        answer = Math.max(cnt, answer);

        for(int i=0; i<dungeons.length; i++){
            if(visited[i] == true) continue; 
            
            if(dungeons[i][0]<=cur){
                visited[i] = true;
                dfs(cur-dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
        
        
    }
}