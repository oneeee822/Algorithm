#include <bits/stdc++.h>
using namespace std;

int solution(int N, vector<vector<int>> road, int K) {
    int answer = 0;
    vector<vector<pair<int,int>>> nodes(N+1);
    set<pair<int,int>> check;
    bool node[51] = {false};
    vector<int> minRoad(N+1); 
    
    //adj 초기화
    for(auto r : road){
        nodes[r[0]].push_back({r[1],r[2]});
        nodes[r[1]].push_back({r[0],r[2]});
    }
    
    queue<pair<int,int>> q;
    q.push({1,0});
    node[1]=true;
    
    while(!q.empty()){
        pair<int,int> start = q.front();
        q.pop();
        
        for(auto arrive : nodes[start.first]){
            int distance = start.second + arrive.second;
            
            if(distance<=K){
                // 처음 가는 길이거나 최소 길이면 q에 넣기
                if((check.find({start.first, arrive.first})==check.end())||minRoad[arrive.first]>distance) {
                    q.push({arrive.first,distance});
                    minRoad[arrive.first]=distance;                           }
                node[arrive.first]=true;
                
                check.insert({start.first, arrive.first});
                check.insert({arrive.first,start.first});
            } 
        }
    }
    
    for(int i=1; i<51; i++){
        if(node[i]) answer++;
    }

    return answer;
}