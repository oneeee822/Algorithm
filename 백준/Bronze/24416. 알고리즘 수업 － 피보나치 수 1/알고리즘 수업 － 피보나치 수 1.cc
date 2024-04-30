#include <iostream>
using namespace std;

int recursive = 0;
int dp = 0;

int fib(int n){
    
    if(n==1 || n==2){
        recursive++;
        return 1;
    }
    
    else {
        return (fib(n-1)+ fib(n-2));
    }
}

void fibonacci(int n){
    int f[n+1];
    f[1]=f[2]=1;
    for(int i =3;i<=n; i++){
        f[i]= f[i-1]+f[i-2];
        dp++;
    }
}

int main()
{
    int n;
    
    cin>>n;
    fib(n);
    fibonacci(n);
    
    cout<<recursive<<" "<<dp;
    
    
    
}