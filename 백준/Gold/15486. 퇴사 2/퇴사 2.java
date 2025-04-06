import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N+1];
		int[] p = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++){
		    st = new StringTokenizer(br.readLine());
		    t[i] = Integer.parseInt(st.nextToken());
		    p[i] = Integer.parseInt(st.nextToken());
 		}
 		

 		for(int i=1; i<=N; i++){
 		    dp[i] = Math.max(dp[i-1], dp[i]);
 		    
 		    if(i+t[i]-1 <= N){
 		        dp[i+t[i]-1] = Math.max(dp[i+t[i]-1], dp[i-1]+p[i]);
 		    }
 		}
 		
 		System.out.println(dp[N]);
	}
}