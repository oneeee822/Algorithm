import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] hx = {-2,-2,-1,1,2,2,-1,1};
    static int[] hy = {1,-1,2,2,1,-1,-2,-2};
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<W; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		int result = bfs();
		System.out.println(result);
	}
	
	public static int bfs(){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {0,0,0,0});
	    visited[0][0][0] = true;
	    
	    while(!q.isEmpty()){
	        int[] current = q.poll();
	        int curx = current[0];
	        int cury = current[1];
	        int horseMove = current[2];
	        int move = current[3];
	        if(curx==H-1 && cury==W-1) return move;
	        
	        for(int i=0; i<4; i++){
	            int nx = curx +dx[i];
	            int ny = cury +dy[i];
	        
	            if(nx<0 || ny<0 ||nx>=H || ny>=W) continue;
	            if(map[nx][ny]==0 && !visited[nx][ny][horseMove]){
	                q.add(new int[] {nx, ny, horseMove, move+1});
	                visited[nx][ny][horseMove]=true;
	            }
	        }
	        
	        if(horseMove<K){
	            for(int i=0; i<8; i++){
	                int nx = curx +hx[i];
	                int ny = cury +hy[i];
	        
	                if(nx<0 || ny<0 ||nx>=H || ny>=W) continue;
	                if(map[nx][ny]==0 && !visited[nx][ny][horseMove+1]){
	                    q.add(new int[] {nx, ny, horseMove+1, move+1});
	                    visited[nx][ny][horseMove+1]=true;
	                }
	            }
	        }
	    }
	    return -1;
	}
}