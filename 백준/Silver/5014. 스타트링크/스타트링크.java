import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    static int F,S,G;
    static int[] UD = new int[2];
    static int[] floorCnt;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		UD[0] = Integer.parseInt(st.nextToken());
		UD[1] = Integer.parseInt(st.nextToken());
		
		floorCnt = new int[F+1];
		visited = new boolean[F+1];
		
		int answer = bfs(S);
		if(answer==-1){
		    System.out.println("use the stairs");
		}
		else{
		    System.out.println(answer);
		}
	}
	
	public static int bfs(int S){
	    Queue<Integer> q = new LinkedList<>();
	    q.add(S);
	    visited[S]=true;
	    int move = 0;
	    
	    while(!q.isEmpty()){
	        int cur = q.poll();
	        
	        if(cur==G){
	            return floorCnt[cur];
	        }
	        
	        for(int i=0; i<2; i++){
	            int now = 0;
	            if(i==0){
	                now = cur + UD[0];
	            }
	            else{
	                now = cur - UD[1];
	            }
	            if(now>0 && now<=F && visited[now]!=true){
	                q.add(now);
	                visited[now]=true;
	                floorCnt[now] = floorCnt[cur] + 1;
	            }
	        }
	        
	    }
	    
	    return -1;
	}
}