import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
    
        dfs(begin, target, words, 0, visited);
        
        return answer<Integer.MAX_VALUE? answer : 0 ;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt, boolean[] visited){
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
        }
        
        for(int i=0; i<words.length; i++){
            int diff=0;
            for(int j=0; j<begin.length(); j++){
                if(diff>1) break;
                if(begin.charAt(j)!=words[i].charAt(j)) diff++;
            }
            if(diff==1 && !visited[i]){
                visited[i] = true;
                dfs(words[i], target, words, cnt+1, visited);
                visited[i] = false;
            }
        }
    }
}