#include <bits/stdc++.h>
using namespace std;

// 2*2확인해서 지울 거 체크
bool twoXtwo(char kakao, int x, int y, int m, int n, vector<vector<bool>>& check, vector<string>& board){
    if(kakao=='.') return false;
    
    int dx[] = {0,1,1,0};
    int dy[] = {0,0,1,1};
    
    bool remove = true;
    if(x+1<m && y+1<n){
        
        for(int i=0; i<4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];
            
            if(board[curX][curY]!=kakao){
                remove = false;
                break;
            }
        }
        if(remove){
            for(int i=0; i<4; i++){
                int curX = x + dx[i];
                int curY = y + dy[i];
                check[curX][curY] = true;
            }
        }
    }
    return remove;
}

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    vector<vector<bool>> check(m, vector<bool>(n, false));
    bool removed = true;
    
    //더 떨어질 게 있을 때까지
    while(removed){
        removed = false;
        
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                bool current = twoXtwo(board[i][j],i,j,m,n,check,board);
                removed = removed || current;
            }
        }
    
        //지우기
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(check[i][j]) {
                    board[i][j]='.';
                    answer++;
                }
            }
        }
    
        //캐릭터 내리기 
        for(int j=0; j<n; j++){
            int write = m-1;
            
            for(int i=m-1; i>-1; i--){
                if(board[i][j]!='.'){
                    board[write][j] = board[i][j];
                    write--;
                }
            }
            
            while(write >= 0){
                board[write][j] = '.';
                write--;
            }
        }
        
        check = vector<vector<bool>>(m, vector<bool>(n, false));
    }
    
    
    return answer;
}