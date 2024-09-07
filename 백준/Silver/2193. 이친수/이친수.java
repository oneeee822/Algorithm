import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long dp[] = new long[N];
        
        if (N == 1) {
            System.out.println(1);
            return;
        }
        
        dp[0]=1;
        dp[1]=1;
        for(int i =2; i<N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        System.out.println(dp[N-1]);
    }
}