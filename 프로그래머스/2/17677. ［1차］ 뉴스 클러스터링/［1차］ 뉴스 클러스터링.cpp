#include <bits/stdc++.h>

using namespace std;

int solution(string str1, string str2) {
    map<string, int> map1;
    map<string, int> map2;
    int intersectionNum=0;
    int unionNum=0;
    
    // 문자열 다 소문자로 만들기
    transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
    
    // 문자인 경우에만 문자열 두 글자씩 다중 집합 만들기
    for(int i=0; i<str1.length()-1; i++){
        if(isalpha(str1[i]) && isalpha(str1[i+1]))
            map1[(str1.substr(i,2))]++;
    }
    for(int i=0; i<str2.length()-1; i++){
        if(isalpha(str2[i]) && isalpha(str2[i+1]))
            map2[(str2.substr(i,2))]++;
    }
    
    for(auto [key, value] : map1){
        intersectionNum += min(value, map2[key]);
        unionNum += max(value, map2[key]);
    }
    
    for(auto [key, value] : map2){
        if(map1.find(key)==map1.end()){
            unionNum+=value;
        }
    }
    
    if (unionNum == 0) return 65536;
    
    return intersectionNum*65536/unionNum ;
}