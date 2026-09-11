#include <bits/stdc++.h>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    map<string, int> map;
    vector<bool> visited(msg.length(), false);
    int next = 27;
    
    map["A"]=1;map["B"]=2;map["C"]=3;map["D"]=4;map["E"]=5;map["F"]=6;map["G"]=7;map["H"]=8;map["I"]=9;map["J"]=10;map["K"]=11;map["L"]=12;map["M"]=13;map["N"]=14;map["O"]=15;map["P"]=16;map["Q"]=17;map["R"]=18;map["S"]=19;map["T"]=20;map["U"]=21;map["V"]=22;map["W"]=23;map["X"]=24;map["Y"]=25;map["Z"]=26;
    
    for(int i=0; i<msg.length(); i++){
        if(visited[i]) continue;
        int j = 1;
        
        while(msg.length()>=i+j && map.find(msg.substr(i,j)) != map.end()){ // 매칭되는 가장 긴 문자열
            j++;
        }  
        
        answer.push_back(map[msg.substr(i,j-1)]);
        for(int k=0; k<j-1; k++){
            visited[i+k]=true;
        }
        
        map[msg.substr(i,j)]=next++;
    }
    
    return answer;
}