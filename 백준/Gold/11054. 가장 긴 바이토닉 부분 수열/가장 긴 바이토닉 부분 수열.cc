#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
   int n;
   cin>>n;
   
   int arr[n];
   int adp[n];
   int ddp[n];
   
   for(int i=0; i<n; i++) {
       cin>>arr[i];
       adp[i]=1;
       ddp[i]=1;
   }
   
   for(int i=0; i<n; i++){
       for(int j=0; j<i; j++){
           if(arr[j]<arr[i]){
               adp[i] = max(adp[i], adp[j]+1);
           }
       }
       
   }
   
   for(int i=n-1; i>=0; i--){
       for(int j=n-1; j>i; j--){
           if(arr[j]<arr[i]){
               ddp[i] = max(ddp[i], ddp[j]+1);
           }
       }
   }
 
   
   int ans=0;
   
   for(int i=0; i<n; i++){
       ans = max(ans, adp[i]+ddp[i]-1);
   }
   
   
   cout<<ans<<"\n";
}