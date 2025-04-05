import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[1000001];
		int[] pre = new int[1000001];
		String str = "";
		
		int N = Integer.parseInt(br.readLine());
		
	    dp[1]=0;
	    pre[1]=0;
	    for(int i=2; i<=N; i++){
	        dp[i]=dp[i-1]+1;
	        pre[i]=i-1;
	        
	        if(i%2==0 && dp[i/2]+1<dp[i]) {
	            dp[i] = dp[i/2]+1;
	            pre[i] = i/2;
	        }
	        if(i%3==0 && dp[i/3]+1<dp[i]) {
	            dp[i] = dp[i/3]+1;
	            pre[i] = i/3;
	        }
	    }
	    
	    System.out.println(dp[N]);
	    str += N+" ";
	    while(pre[N]!=0){
	        str += pre[N]+" ";
	        N=pre[N];
	    }
	    
	    System.out.print(str);
	    
	}
}