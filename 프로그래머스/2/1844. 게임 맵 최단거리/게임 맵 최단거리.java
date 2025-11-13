import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {0,0});
        visited[0][0] = true;
        distance[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            int nx = now[0];
            int ny = now[1];
            
            for(int i=0; i<4; i++){
                int x = nx + dx[i];
                int y = ny + dy[i];
                
                if(x<0 || x>n-1 || y<0 || y>m-1 || maps[x][y]==0 || visited[x][y])
                continue;
                
                q.add(new int[] {x,y});
                visited[x][y] = true;
                distance[x][y] = distance[nx][ny]+1;
            }
        }
        
        if(distance[n-1][m-1]==0)
            return -1;
        else
            return distance[n-1][m-1];
    }
}