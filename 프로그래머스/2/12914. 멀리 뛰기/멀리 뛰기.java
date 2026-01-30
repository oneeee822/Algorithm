import java.util.*;

class Solution {
    public static int num = 1234567;
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2000];
        
        dp[0]=1;
        dp[1]=2;
        for(int i=2; i<n; i++){
            dp[i]= (dp[i-1]+dp[i-2])%num;

}
        return dp[n-1];
    }
}