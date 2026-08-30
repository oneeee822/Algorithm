class Solution {
    public int solution(int[][] info, int n, int m) {

        int[] dp = new int[n];

        for (int a = 0; a < n; a++) {
            dp[a] = m;
        }

        dp[0] = 0;

        for (int i = 0; i < info.length; i++) {

            int[] next = new int[n];

            for (int a = 0; a < n; a++) {
                next[a] = m;
            }

            for (int a = 0; a < n; a++) {

                if (dp[a] >= m) continue;

                int nextA = a + info[i][0];

                if (nextA < n) next[nextA] = Math.min(next[nextA], dp[a]);

                int nextB = dp[a] + info[i][1];

                if (nextB < m) next[a] = Math.min(next[a], nextB);
            }

            dp = next;
        }


        for (int a = 0; a < n; a++) {
            if (dp[a] < m) return a;
        }

        return -1;
    }
}