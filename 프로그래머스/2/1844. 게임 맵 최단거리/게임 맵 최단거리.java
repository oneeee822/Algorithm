import java.util.*;

class Solution {
    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] way = new int[maps.length][maps[0].length];
            
        bfs(maps, visited, way);
        return (way[maps.length-1][maps[0].length-1]==0) ? -1:way[maps.length-1][maps[0].length-1];
    }
    
    public void bfs(int[][] maps, boolean[][] visited, int[][] way){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        way[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                
                if(x>=maps.length || x<0 ||y>=maps[0].length|| y<0)
                    continue;
                if(visited[x][y]) continue;
                if(maps[x][y] == 0) continue;
                
                q.add(new int[]{x, y});
                visited[x][y] = true;
                way[x][y] = way[cur[0]][cur[1]] + 1;
            }
        }
    }
}