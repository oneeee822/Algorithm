import java.util.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(String[] maps) {
        int answer = 0;
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)=='S'){
                    answer = bfs(maps, i, j);
                    break;
                }
            }
        }
        return answer;
    }
    
    public int bfs(String[] maps, int i, int j){
        int time = 0;
        
        // 레버찾고
        int[] foundLever = found(maps, i, j, 'L');
        
        // 출구 찾고
        int[] foundExit = found(maps, foundLever[1], foundLever[2], 'E');

        if(foundLever[0]==0 || foundExit[0]==0) return -1;
        return foundLever[0]+foundExit[0];
    }
    
    public int[] found(String[] maps, int i, int j, char ch){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j, 0});
        
        int time = 0;
        int chX = 0;
        int chY = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(maps[cur[0]].charAt(cur[1])==ch) {
                time = cur[2];
                chX = cur[0];
                chY = cur[1];
                break;
            }
            
            for(int z=0; z<4; z++){
                int x = cur[0] + dx[z];
                int y = cur[1] + dy[z];
                
                if(x<0 || y<0 || x>=maps.length || y>=maps[0].length() || visited[x][y]) continue;
                
                if(maps[x].charAt(y)!='X'){
                    visited[x][y] = true;
                    q.add(new int[] {x, y, cur[2]+1});
                } 
            }
        }
        
        return new int[] {time, chX, chY};
    }
}