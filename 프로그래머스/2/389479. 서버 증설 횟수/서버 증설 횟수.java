import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = 0;
        int add = 0;
        int[] server = new int[24];
        
        for(int i=0; i<24; i++){
            if(i-k>=0){
                    n -= server[i-k];
                }
            
            if(players[i]>m*(n+1)-1){ 
                add = players[i]/m - n;
                server[i] = add;
                n += add;
                answer += add;
            }
        }
        return answer;
    }
}