#include <iostream>
#include <vector>
using namespace std;

int backpack(int N,int K,vector<int>& W,vector<int>& V){
    vector<vector<int>> dp(N+1,vector(K+1,0));
    
    for(int i=1; i<=N; ++i){
        for(int w=1; w<=K; ++w){
            if(W[i-1]>w){
                dp[i][w] = dp[i-1][w];            
            }else{
                dp[i][w] = max(dp[i-1][w], dp[i-1][w-W[i-1]]+V[i-1]);
            }
        }
    }
    return dp[N][K];
}

int main(){
    int N,K;
    cin>>N>>K;
    vector<int> W(N), V(N);
    
    for(int i=0; i<N; ++i){
        cin>>W[i]>>V[i];
    }
    
    cout<<backpack(N,K,W,V);
    return 0;
}