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
            int[] files = new int[K+1];
            int dp[][] = new int[K+1][K+1];

            st = new StringTokenizer(br.readLine());
            files[1] = Integer.parseInt(st.nextToken());
            for(int i=2; i<=K; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                files[i] = tmp+files[i-1];
            }


            for(int gap=1; gap<K; gap++) {
                for(int start = 1; start+gap <= K; start++) {
                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;

                    for(int mid = start; mid<end ;mid++) {
                        dp[start][end] = Math.min(dp[start][end],dp[start][mid]+dp[mid+1][end]+files[end]-files[start-1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}