import java.util.*;

class Solution {
    int cnt = -1;
    public int solution(int k, int[][] dungeons) {

        for(int i=0; i<dungeons.length; i++){
            boolean[] visited = new boolean[dungeons.length];
            dfs(k, dungeons, visited, 0);
        }
        
        return cnt;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int num){
        cnt = Math.max(cnt, num);
        if(num==dungeons.length){
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(k>=dungeons[i][0]&&!visited[i]) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited, num+1);
                visited[i] = false;
            }
        }
    }
}