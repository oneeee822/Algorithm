import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static int N, K;
    static int[] location = new int[100001];
    static boolean[] visited = new boolean[100001];
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int time = bfs(N);
		
		System.out.println(time);
	}
	
	public static int bfs(int n){
	    Queue<Integer> q = new LinkedList<>();
	    q.add(n);
	    visited[n] = true;
	    
	    while(!q.isEmpty()){
	        int current = q.poll();
	        
	        if(current==K) return location[current];
	        
	        if(2*current <= 100000 && !visited[2*current]){
	            location[2*current] = location[current];
	            q.add(2*current);
	            visited[2*current] = true;
	        }
	        if(current-1>=0 && !visited[current-1]){
	            location[current-1] = location[current]+1;
	            q.add(current-1);
	            visited[current-1] = true;
	        }
	        if(current+1<=100000 && !visited[current+1]){
	            location[current+1] = location[current]+1;
	            q.add(current+1);
	            visited[current+1] = true;
	        }
	        
	        
	    }
	    return -1;
	}
}