class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int dp[] = new int[money.length];
        
        dp[0]= money[0];
        dp[1]= Math.max(money[0], money[1]);
        for(int i = 2; i<money.length-1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + money[i]);
        }
        int max1 = dp[money.length-2];
        
        dp[0] = 0; 
        dp[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        int max2 = dp[money.length- 1];
        
        return Math.max(max1, max2);
    }
}