import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    int[][] num;
    boolean[][] visited;

    ArrayList<Integer> patchSizes = new ArrayList<>();
    Set<Integer> s;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;    
        int m = land[0].length; 
        visited = new boolean[n][m];
        num = new int[n][m];
        
        patchSizes.add(0);
        int patchId = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && land[i][j]==1){
                    
                    int cnt = bfs(i, j, n, m, land, patchId);
                    patchSizes.add(cnt);
                    patchId++;
                }
            }
        }
        
        for(int i=0; i<land[0].length; i++){
            s = new HashSet<>();
            int sum = 0;
            for(int j=0; j<land.length; j++){
                s.add(num[j][i]);
            }
            
            for(Integer id : s){
                sum += patchSizes.get(id);
            }
            
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    public int bfs(int x, int y, int n, int m, int[][] land, int patchId){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {x,y});
        visited[x][y] = true;
        num[x][y] = patchId;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            
            int nx = now[0];
            int ny = now[1];
            
            for(int i=0; i<4; i++){
                int curx = nx + dx[i];
                int cury = ny + dy[i];
                
                if(curx<0 || curx>=n || cury<0 || cury>=m){
                    continue;
                }
                
                if(visited[curx][cury] || land[curx][cury]==0)
                    continue;
                
                q.add(new int[] {curx, cury});
                visited[curx][cury] = true;
                num[curx][cury] = patchId;
            }
        }
        return cnt;
    }
}