import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    static int M,N,K;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] square;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		square = new boolean[M][N]; // true가 직사각형
		visited = new boolean[M][N];
		
		int[] coordinate = new int[4];
		for(int i=0; i<K; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<4; j++){
		        coordinate[j] = Integer.parseInt(st.nextToken());
		    }

		    for(int k=coordinate[1]; k<coordinate[3]; k++){
		        for(int l=coordinate[0]; l<coordinate[2]; l++){
		            if(!square[k][l]){
		                square[k][l] = true;
		                visited[k][l] = true;
		            }
		        }
		    }
		}
		
		int area = 0;
		List<Integer> list = new ArrayList<>();
        for(int k=0; k<M; k++){
	        for(int l=0; l<N; l++){
	            if(!square[k][l]&& !visited[k][l]){
	                area = dfs(k,l);
	                list.add(area);
		        }
		    }
	    }
		    
		Collections.sort(list);
		System.out.println(list.size());
		for(Integer l : list){
		    System.out.print(l+" ");
		}
	}
	
	public static int dfs(int x , int y){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {x,y});
	    visited[x][y] = true;
	    
	    int cnt = 1;
	    while(!q.isEmpty()){
	        int[] current = q.poll(); 
	        int curx = current[0];
	        int cury = current[1];
	        
	        for(int i=0; i<4; i++){
	            int nx = curx + dx[i];
	            int ny = cury + dy[i];
	            
	            if(nx<0 || ny<0 || nx>=M || ny >= N) continue;
	            if(!square[nx][ny] && !visited[nx][ny]){
	                q.add(new int[] {nx, ny});
	                visited[nx][ny] = true;
	                cnt++;
	            }
	            
	        }
	    }
	    
	    return cnt;
	}
}