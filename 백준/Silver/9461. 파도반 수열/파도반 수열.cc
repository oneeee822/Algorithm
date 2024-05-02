#include <iostream>
using namespace std;

int main()
{
    int T;
    cin>>T;
    
    while(T--){
        int N;
        cin>>N;
    
        long long dp[101]={0,1,1,1,};
    
        for(int i=4; i<=N; i++){
            dp[i] = dp[i-2]+dp[i-3];
        }
        
        cout<<dp[N]<<"\n";   
    }
}