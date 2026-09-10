#include <bits/stdc++.h>
using namespace std;

string toK(int n, int k){
    string result = "";
    
    while(n>0){
        int remainder = n%k;
        
        result += '0' + char(remainder);
        
        n/=k;
    }
    
    reverse(result.begin(), result.end());
    return result;
}

bool isPrime(long long n){
    if(n==1) return false;
    if(n==2) return true;
    
    long long limit = sqrt(n);
    for (long long i = 2; i <= limit; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    string nstr = toK(n,k);
    
    stringstream ss(nstr);
    string temp;
    vector<string> arr;
    
    while(getline(ss,temp,'0')){
        arr.push_back(temp);
    }
    
    for(auto num : arr){
        if(num=="") continue;
        if(isPrime(stoll(num))) answer++;
    }
    
    return answer;
}