import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int change = Integer.parseInt(br.readLine()); 
        if(change==1 || change==3){
            System.out.println(-1);
            return;
        }
        int[] dp = new int[change+1+5];
        
        dp[0] = 0;
        dp[1] = Integer.MAX_VALUE;
        dp[2] = 1;
        dp[3] = Integer.MAX_VALUE;
        dp[4] = 2;
        
        for(int i=5; i<=change; i++){
            dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
        }
        
        System.out.println(dp[change]);
    }
}
