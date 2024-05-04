#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    cin>>N;
    
    int w[N+1]={0};
    int dp[N+1]={0};
    
    for(int i=1; i<=N; i++) cin>>w[i];
    
    dp[1]=w[1];
    dp[2]=w[1]+w[2];
    
    for(int i=3; i<=N; i++){
        dp[i] = max({dp[i-3]+w[i-1]+ w[i], dp[i-2]+w[i],dp[i-1]});
    }
    
    cout<<dp[N]<<"\n";
}