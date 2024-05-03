#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
   int N;
   cin>>N;
   
   int stair[301]={0};
   int dp[301][3]={0};
   
   
   for(int i=1; i<=N; i++) {
       cin>>stair[i];
   }
   
   dp[1][1]=stair[1];
   dp[2][1]=stair[2];
   dp[2][2]=dp[1][1]+stair[2];
  
   for(int i=3; i<=N; i++){
        for(int j=1; j<=2; j++){
            if(j%2==0){ // 연속으로 오른 계단이 두 개의 계단일 때
                dp[i][j]=dp[i-1][1]+stair[i];
            }
            else{// 연속으로 오른 계단이 한 개일 때
                dp[i][j]=max(dp[i-2][2],dp[i-2][1])+stair[i];
            }
        }
        
   }
    
    cout<<max(dp[N][1],dp[N][2])<<"\n";
}