import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[41];
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] vip = new int[M];
		
		for(int i=0; i<M; i++){
		    vip[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1; 
		dp[1] = 1;
		
		for(int i=2; i<=N; i++){
		    dp[i] = dp[i-1]+ dp[i-2];
		}
		
		int result = 1;
		int prev = 0;
		for(int i=0; i<M; i++){
		    int cur = vip[i];
		    result *= dp[cur-prev-1]; // vip사이의 거리
		    prev = cur;
		}
		result *= dp[N-prev]; // 마지막 vip와 배열끝까지의 경우
		
		System.out.println(result);
	}
}