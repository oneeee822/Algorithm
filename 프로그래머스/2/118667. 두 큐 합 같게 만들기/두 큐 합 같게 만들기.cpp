#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum1 = 0;
    long long sum2 = 0;
    int cnt=0;
    queue<int> q1;
    queue<int> q2;
    int maxCnt = queue1.size()*4;
    
    for(int q : queue1){
        sum1+=q;
        q1.push(q);
    }
    for(int q : queue2){
        sum2+=q;
        q2.push(q);
    }
    
    if((sum1+sum2)%2!=0) return -1;
    
    int tmp = 0;
    while(cnt<maxCnt){
        if(sum1<sum2 && !q2.empty()){
            tmp = q2.front();
            q2.pop();
            
            q1.push(tmp);
            cnt++;
            
            sum1+=tmp;
            sum2-=tmp;
            
        }
        else if(sum1>sum2 && !q1.empty()){
            tmp = q1.front();
            q1.pop();
            
            q2.push(tmp);
            cnt++;
            
            sum2+=tmp;
            sum1-=tmp;
        }
        else{
            return cnt;
        }
    }
    
    return -1;
}