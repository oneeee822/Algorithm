import java.util.*;

class Solution {
    public static int cnt = 0;
    public int solution(int n, int[][] computers) {
        cnt = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]) {
                cnt++;
                dfs(visited, computers, i);
            }
        }
        
        return cnt;
    }
    
    public void dfs(boolean[] visited, int[][] computers, int i){
        visited[i]=true;
        for(int k=0; k<computers.length; k++){
            if(computers[i][k]==1 && !visited[k]) {
                dfs(visited, computers, k);
            }
        }
    }
}