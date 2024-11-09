import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static int N;
    static char[][] pic;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int cnt = 0;
    static int blind_cnt = 0;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++){
		    String line = br.readLine();
		    for(int j=0; j<N; j++){
		        pic[i][j]=line.charAt(j);
		    }
		}
		
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(!visited[i][j]) bfs(i,j);
		    }
		}
		
		visited = new boolean[N][N];
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(!visited[i][j]) blind_bfs(i,j);
		    }
		}
		System.out.println(cnt + " " + blind_cnt);
	}
	
	public static void bfs(int x, int y){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {x,y});
	    visited[x][y] = true;
	    char color = pic[x][y];
	    
	    while(!q.isEmpty()){
	        int[] current = q.poll();
	        int curx = current[0];
	        int cury = current[1];
	        
	        for(int i=0; i<4; i++){
	            int nx = curx + dx[i];
	            int ny = cury + dy[i];
	            
	            if(nx<0 || ny<0 || nx>= N || ny>=N) continue;
	            if(color == pic[nx][ny] && !visited[nx][ny]){
	                q.add(new int[] {nx,ny});
	                visited[nx][ny] = true;
	            }
	        }
	    }
	    cnt++;
	}
	
	public static void blind_bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        char color = pic[x][y];

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int curx = current[0];
            int cury = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                
                if (!visited[nx][ny] && 
                   ((color == 'R' || color == 'G') && (pic[nx][ny] == 'R' || pic[nx][ny] == 'G') || color == pic[nx][ny])) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        blind_cnt++;
    }
}