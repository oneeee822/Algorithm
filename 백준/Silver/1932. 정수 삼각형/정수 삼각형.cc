#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
   int N;
   cin>>N;
   
   int dp[500][500]={0};
   int ans=0;
   
   for(int i=0; i<N; i++) {
       for(int j=0; j<=i; j++){
           cin>>dp[i][j];
        }
   }
   
   
   for(int i=0; i<N; i++){
        for(int j=0; j<=i; j++){
            if(j==0) dp[i][j]= dp[i-1][j]+dp[i][j];
            else {
                dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + dp[i][j];
            }
            
            ans = max(ans, dp[i][j]);
        }
        
   }
    
    cout<<ans<<"\n";
}