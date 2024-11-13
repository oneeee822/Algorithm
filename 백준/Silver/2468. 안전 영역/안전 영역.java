import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static int N;
    static int[][] region;
    static boolean[][] visited;
    static int minHeight = Integer.MAX_VALUE;
    static int maxHeight=0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		region = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        region[i][j] = Integer.parseInt(st.nextToken());
		        if(maxHeight<region[i][j]){
		            maxHeight = region[i][j];
		        }
		        if(minHeight>region[i][j]){
		            minHeight = region[i][j];
		        }
		    }
		}
		
		int safezone = 1;
		for(int i=minHeight; i<=maxHeight; i++){
		    
		    visited = new boolean[N][N];
		    for(int j=0; j<N; j++){
	            for(int k=0; k<N; k++){
                    if(region[j][k]<=i){
                        visited[j][k] = true;
	                }
	            }
	 	    }
	 	    
	 	    int cnt = 0 ;
	 	    for(int j=0; j<N; j++){
		        for(int k=0; k<N; k++){
		            if(!visited[j][k]){
		                bfs(j,k,i);
		                cnt++;
		            }
		        }
	        }
	 	    

		    if(safezone<cnt){
		        safezone = cnt;
		    }
		}
		System.out.println(safezone);
	}
	
	public static void bfs(int x, int y, int height){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {x,y});
	    visited[x][y]= true;
	    
	    while (!q.isEmpty()) {  
            int[] current = q.poll();
            int curx = current[0];
            int cury = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && region[nx][ny] > height && !visited[nx][ny]) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}