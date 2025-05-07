import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int j=0; j<t; j++){
		    int n = Integer.parseInt(br.readLine());
		    
		    if (n == 1) {
                System.out.println(1);
                continue;
            } else if (n == 2) {
                System.out.println(2);
                continue;
            } else if (n == 3) {
                System.out.println(4);
                continue;
            }
            
		    long [] dp = new long[n+1];
		    
		    dp[0] = 1;
		    dp[1] = 2;
		    dp[2] = 4;
 		    for(int i=3; i<n; i++){
		        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009 ;
		    }
		    System.out.println(dp[n-1]);
		}
	}
}
