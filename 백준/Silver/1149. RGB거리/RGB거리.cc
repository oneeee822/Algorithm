#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
   int N;
   cin>>N;
   
   int cost[3];
   int dp[1001][3];
   
   
   for(int j=0; j<3; j++) {
       cin>>cost[j];
       dp[1][j]= cost[j];
   }
   
   
   for(int i=2; i<=N; i++){
        for(int j=0; j<3; j++) cin>>cost[j];
        
        dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + cost[0];
        dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + cost[1];
        dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + cost[2];
        
        
   }
 
    int ans = min({dp[N][0],dp[N][1],dp[N][2]});
    
    cout<<ans<<"\n";
}