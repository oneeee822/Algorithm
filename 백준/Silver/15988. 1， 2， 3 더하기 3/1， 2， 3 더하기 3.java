import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	
	public static int N, T;
	public static long[] dp;
	public static int answer;
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	dp = new long[1000001];
    	T = Integer.parseInt(st.nextToken());
    	
    	dp[1] = 1;
    	dp[2] = 2;
    	dp[3] = 4;
    	dp[4] = dp[4-1] + dp[4-2] + dp[4-3];
    	for(int i=4; i<1000001;i++) {
    		dp[i] = ( dp[i-1] + dp[i-2] + dp[i-3] ) % 1000000009;
    	}
    	
    	for(int t=0;t<T;t++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		System.out.println(dp[N] % 1000000009);
    	}
    }
}