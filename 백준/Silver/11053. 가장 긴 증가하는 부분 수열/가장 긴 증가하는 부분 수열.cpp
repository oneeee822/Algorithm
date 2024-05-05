#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin>>n;
    
    int w[n];
    int dp[n];
    
    for(int i=0; i<n; i++){
        cin>>w[i];
        dp[i]=1;  //초기화
    }

    for(int i=1; i<n; i++){
        for(int j=0; j<i; j++){
            if(w[i]>w[j]){
                dp[i] = max(dp[i],dp[j]+1);
            }
        }
        
    }
    
    sort(dp,dp+n);
    cout<<dp[n-1];
}
