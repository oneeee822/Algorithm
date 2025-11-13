class Solution {
    int answer = 0;
    boolean[] visited = new boolean[9];
    public int solution(int k, int[][] dungeons) {
        
        for(int i=0; i<dungeons.length; i++)
            dfs(i, 0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int i, int depth, int k, int[][] dungeons){
        if(k<dungeons[i][0]){
            answer = Math.max(answer, depth);
            return;
        }
        
        visited[i] = true;
        for(int j=0; j<dungeons.length; j++){
            if(!visited[j]){
                dfs(j, depth+1, k-dungeons[i][1], dungeons);
            }
        }
        
        visited[i] = false;
        answer = Math.max(answer, depth+1);
        
        
    }
}