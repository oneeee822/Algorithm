import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] Csum = new int[K+1];
            int[][] dp = new int[K][K];
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=K; i++){
                Csum[i] = Integer.parseInt(st.nextToken()) + Csum[i-1];
            }
        
            for(int gap = 1; gap < K; gap++) {
                for(int start = 0; start + gap < K; start++) {
                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + Csum[end + 1] - Csum[start]);
                    }
                }
            }
            System.out.println(dp[0][K-1]);
        }
    }
}