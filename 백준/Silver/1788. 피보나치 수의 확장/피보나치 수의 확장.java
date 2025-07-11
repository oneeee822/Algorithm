import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException{
        final int MOD = 1000000000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int absn = Math.abs(n);
        int[] dp = new int[absn + 2];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= absn; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        int sign;
        if (n > 0) {
            sign = 1;
        } else if (n == 0) {
            sign = 0;
        } else {
            sign = (absn % 2 == 0) ? -1 : 1;
        }

        System.out.println(sign);
        System.out.println(dp[absn]);
    }
}
