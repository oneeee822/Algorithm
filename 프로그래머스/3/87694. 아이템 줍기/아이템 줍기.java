import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1,-1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] rect = new int[102][102];
        
        makeMap(rectangle, rect);
        
        return bfs(rect, characterX, characterY, itemX, itemY);
    }
    
    public void makeMap(int[][] rectangle, int[][] rect){
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int x=x1; x<=x2; x++){
                for(int y=y1; y<=y2; y++){
                    rect[x][y]=1; 
                }
            }
        }
        
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int x=x1+1; x<x2; x++){
                for(int y=y1+1; y<y2; y++){
                    rect[x][y]=0;
                }
            }
        }
    }
    
    public int bfs(int[][] rect, int characterX, int characterY, int itemX, int itemY){
        int[][] dist = new int[102][102];
        boolean[][] visited = new boolean[102][102];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX*2, characterY*2});
        visited[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0]==itemX*2 && cur[1]==itemY*2) return dist[cur[0]][cur[1]]/2;
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>101 || ny<0 || ny>101) continue;
                
                if(rect[nx][ny]==1 && !visited[nx][ny]){
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
        return 0;
    }
}