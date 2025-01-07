import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CCTV{
    int num;
    int x;
    int y;
    CCTV(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class Main
{
    public static int N, M;
	public static int workspace[][];
	public static int copyWorkspace[][];
	public static ArrayList<CCTV> cctvList;
	public static int output[];
	public static int answer = Integer.MAX_VALUE;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctvList = new ArrayList<>();
		
		workspace = new int[N][M];
		
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<M; j++){
		        workspace[i][j] = Integer.parseInt(st.nextToken());
		        if(workspace[i][j]!=0 && workspace[i][j]!=6){
		            cctvList.add(new CCTV(workspace[i][j],i,j));
		        }
		    }
		}
		
		output = new int[cctvList.size()];
		permutation(0,cctvList.size());
		
		System.out.println(answer);
	}
	
	public static void permutation(int depth, int r){
	    if(depth==r){
	        copyWorkspace = new int[N][M];
	        for(int i = 0; i < workspace.length; i++) {
				System.arraycopy(workspace[i], 0, copyWorkspace[i], 0, workspace[i].length);
			}
			
			for(int i=0; i<cctvList.size(); i++){
			    direction(cctvList.get(i), output[i]);
			}
			
			getBlind();
			
			return;
	    }
	    
	    for(int i=0; i<4; i++){
	        output[depth]=i;
	        permutation(depth+1,r);
	    }
	}
	
	public static void direction(CCTV cctv, int d){
	    int cctvNum = cctv.num;
	    
	    if(cctvNum == 1) {
			if(d == 0) watch(cctv, 0);  
			else if(d == 1) watch(cctv, 1); 
			else if(d == 2) watch(cctv, 2);  
			else if(d == 3) watch(cctv, 3); 
		} else if(cctvNum == 2) {
			if(d == 0 || d == 2) {
				watch(cctv, 0); watch(cctv, 2); 
			} else {
				watch(cctv, 1); watch(cctv, 3); 
			}
		} else if(cctvNum == 3) {
			if(d == 0) {
				watch(cctv, 0); 
				watch(cctv, 1);
			} else if(d == 1) { 
				watch(cctv, 1); 
				watch(cctv, 2);
			} else if(d == 2) { 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) { 
				watch(cctv, 0); 
				watch(cctv, 3);
			}
		} else if(cctvNum == 4) {
			if(d == 0) {
				watch(cctv, 0);  
				watch(cctv, 1);
				watch(cctv, 3);
			} else if(d == 1) {
				watch(cctv, 0);  
				watch(cctv, 1);
				watch(cctv, 2);
			} else if(d == 2) {
				watch(cctv, 1); 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) {
				watch(cctv, 0); 
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if(cctvNum == 5) { 
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}
	    
	}
	
	public static void watch(CCTV cctv, int d){
	    Queue<CCTV> q = new LinkedList<>();
	    boolean[][] visited = new boolean[N][M];
	    
	    q.add(cctv);
	    visited[cctv.x][cctv.y] = true;
	    
	    while(!q.isEmpty()){
	        int nx = q.peek().x+dx[d];
	        int ny = q.poll().y+dy[d];
	        
	        if(nx<0 || ny<0 || nx>=N || ny>=M || copyWorkspace[nx][ny]==6)
	            break;
	            
	        if(copyWorkspace[nx][ny]==0){
	            copyWorkspace[nx][ny] = -1;
	            q.add(new CCTV(cctv.num, nx, ny));
	        }
	        else{
	            q.add(new CCTV(cctv.num, nx, ny));
	        }
	    }
	    
	}
	
	public static void getBlind() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyWorkspace[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt);
	}
}