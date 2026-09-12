#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> files) {
    vector<string> answer;
    vector<tuple<string, int, int, string>> fileList;     // head, number, 입력 순서, 원본
    
    int i = 0;
    for(string s : files){
        string head;
        string number;
        int idx = 0;
        
        // head
        while(idx<s.length() && !isdigit(s[idx])) {
            head+=toupper(s[idx]);
            idx++;
        }
        
        // number
        while(idx<s.length() && isdigit(s[idx])) {
            number+=s[idx];
            idx++;
        }
        
        fileList.push_back({head, stoi(number), i, s});
        i++;
    }
    
    // 정렬
    sort(fileList.begin(), fileList.end());
    
    for(auto file : fileList){
        answer.push_back(get<3>(file));
    }
    return answer;
}