import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
        visited = new boolean[N][N];
        
		for(int i=0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}	
		
		int island = 2;
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(map[i][j]==1 && !visited[i][j]){
		            islandBfs(i,j,island);
		            island++;
		        }
		    }
		}
		
		int bridgeLength = Integer.MAX_VALUE;
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(map[i][j]>=2){
		            bridgeLength = Math.min(bridgeLength, buildBridge(i,j));
		        }
		    }
		}
		
		System.out.println(bridgeLength);
	}
		
		
	public static void islandBfs(int x, int y, int island){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {x,y});
	    visited[x][y] = true;
	    map[x][y] = island;
		    
	    while(!q.isEmpty()){
	        int[] current = q.poll();
	        int curx = current[0];
	        int cury = current[1];
		        
	        for(int i=0; i<4; i++){
	            int nx = curx + dx[i];
	            int ny = cury + dy[i];
	            
	            if(nx<0||ny<0||nx>=N||ny>=N) continue;
	            
	            if(map[nx][ny]==1 && !visited[nx][ny]){
	                map[nx][ny] = island;
	                visited[nx][ny] = true;
	                q.add(new int[] {nx,ny});
	            }
	        }
	    }
	}
	
	public static int buildBridge(int x, int y){
	    Queue<int[]> q = new LinkedList<>();
        boolean[][] localVisited = new boolean[N][N];
        q.add(new int[]{x, y, 0}); 
        localVisited[x][y] = true;
        int island = map[x][y];
	    
	    while(!q.isEmpty()){
	        int[] current = q.poll();
	        int curx = current[0];
	        int cury = current[1];
	        int dist = current[2];
	        
	        for(int i=0; i<4; i++){
	            int nx = curx + dx[i];
	            int ny = cury + dy[i];
	      
	            if(nx<0||ny<0||nx>=N||ny>=N) continue;
	            if (localVisited[nx][ny]) continue;
	            
	            if(map[nx][ny]==0 && !localVisited[nx][ny]){
	                q.add(new int[] {nx,ny,dist+1});
	                localVisited[nx][ny] = true;
	            }
	            else if(map[nx][ny]!=island){
	                return dist;
	            }
	       }
	   }
	   return Integer.MAX_VALUE;
	}
}