#include <bits/stdc++.h>
using namespace std;

// n진수 만든느 법
string toN(int num, int n){
    string result = "";
    
    if(num == 0 ) return "0";
    while(num>0){
        int remainder = num%n;
    
        
        if(remainder<10) result += char('0'+remainder);
        else result += char('A'+remainder-10);
        
    
        num/=n;
    }
    
    reverse(result.begin(), result.end());
    return result;
}

string solution(int n, int t, int m, int p) {
    string answer = "";
    int cnt=0;
    string str = "";
    
    for(int i=0; i<=t*m; i++){
        str += toN(i, n);
    }
    
    for(int i=p-1; i<=str.length(); i+=m){
        if(cnt==t) break;
        answer += str[i];
        cnt++;
    }
    
    return answer;
}