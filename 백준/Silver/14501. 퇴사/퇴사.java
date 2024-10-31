import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    T[i] = Integer.parseInt(st.nextToken());
		    P[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+1];
		
		for(int i=0; i<N; i++){
		    dp[i+1] = Math.max(dp[i], dp[i+1]); 
		    
		    if(T[i]+i<=N) 
		        dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
		    
		}
		
		System.out.println(dp[N]);
	}
}