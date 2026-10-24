import java.util.*;

class Solution {
    int diff = 0;
    int[] answer = {-1};
    public int[] solution(int n, int[] info) {
        dfs(n, info, 0, 0, new int[11]);
        return answer;
    }
    
    public void dfs(int n, int[] info, int idx, int cnt, int[] result){
        if(idx==10){
            result[10] = n-cnt;
            
            int apeach = 0;
            int lion = 0;
            for(int i=0; i<10; i++){
                if(info[i]==0 && result[i]==0) continue;
                
                if(info[i]<result[i]){
                    lion+=10-i;
                }
                else{
                    apeach+=10-i;
                }
            }
            
            int scoreDiff = lion-apeach;
            
            if(scoreDiff>0){
                if(scoreDiff > diff){
                    diff = scoreDiff;
                    answer = result.clone();
                }
                else if (scoreDiff == diff) {
                    for (int i = 10; i >= 0; i--) {
                        if (result[i] > answer[i]) {
                            answer = result.clone();
                            break;
                        } else if (result[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            
            result[10]=0;
            return;
        }
        
        int lionWin = info[idx]+1;
        if(lionWin <= n-cnt){
            result[idx] = lionWin;
            dfs(n, info, idx+1, cnt+lionWin, result);
            result[idx] = 0;
        }
        dfs(n, info, idx+1, cnt, result);
    }
}