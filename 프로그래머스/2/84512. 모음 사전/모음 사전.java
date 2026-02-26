import java.util.*;

class Solution {
    static String[] dict = {"A","E","I","O","U"};
    static int answer = 0;
    static int cnt = 0;
    public int solution(String word) {
        for(int i=0; i<5; i++){
            dfs(dict[i], word);
        }
        return answer;
    }
    
    public void dfs(String str, String word){
        if(answer!=0 || str.length()>5) return;
        if(str.equals(word)){
            answer = cnt+1;
            return;
        }

        cnt++;

        for(int i=0; i<5; i++){
            String newStr = str+dict[i];
            dfs(newStr, word);
        }
    }
}