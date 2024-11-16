import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[][] glacier;
    static boolean[][] visited;
    static int[][] meltAmount;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
	    glacier = new int[N][M];
	    visited = new boolean[N][M];
	    meltAmount = new int[N][M];
		
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<M; j++){
		        glacier[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		int year = 0;
		while(true){
		    visited = new boolean[N][M];
		    int glacierCnt = 0;
		    
		    for(int i=0; i<N; i++){
		        for(int j=0; j<M; j++){
		            if(glacier[i][j]!=0 && !visited[i][j]){
		                bfs(i,j);
		                glacierCnt++;
		            }   
		        }
		    }
		    
		    if (glacierCnt > 1) {
                System.out.println(year);
                return;
            }

            if (glacierCnt == 0) {
                System.out.println(0);
                return;
            }
            
            for (int i = 0; i< N; i++) {
                for (int j = 0; j < M; j++) {
                    glacier[i][j] -= meltAmount[i][j];
                    if (glacier[i][j] < 0) glacier[i][j] = 0;
                }
            }
            
		    year++;
		}
	}
	
	public static void bfs(int x, int y){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {x,y});
	    visited[x][y] = true;
	    
	    while(!q.isEmpty()){
	        int[] current = q.poll();
	        int curx = current[0];
	        int cury = current[1];
	        
	        int seaCount = 0;
	        for(int i=0; i<4; i++){
	            int nx = curx + dx[i];
	            int ny = cury + dy[i];
	            
	            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
	            if(glacier[nx][ny]==0) seaCount++;
	            if(glacier[nx][ny]>0 && !visited[nx][ny]){
	                q.add(new int[] {nx,ny});
	                visited[nx][ny]=true;
	            }
	        }
	        
	        meltAmount[curx][cury] = seaCount;
	        
	    }
	}
}