#include <bits/stdc++.h>
using namespace std;

int solution(string dirs) {
    int answer = 0;
    set<tuple<int, int, int, int>> visited;
    vector<string> str;
    map<char, pair<int, int>> map;
    
    map['U'] = {0,1};
    map['D'] = {0,-1};
    map['R'] = {1,0};
    map['L'] = {-1,0};
    
    pair<int, int> cur = {0,0};
    for(char s : dirs){
        int x, y;
        x = cur.first + map[s].first;
        y = cur.second + map[s].second;
        
        if(x<-5 || x>5 || y<-5 || y>5) continue;
        
        auto path1 = make_tuple(cur.first, cur.second, x, y);
        auto path2 = make_tuple(x, y, cur.first, cur.second);

        if(visited.find(path1) != visited.end() ||
           visited.find(path2) != visited.end()) {
            cur = {x, y};
            continue;
        }

        visited.insert(path1);
        visited.insert(path2);

        answer++;

        cur = {x, y};
    }
    
    return answer;
}