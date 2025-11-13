import java.util.*;

class Solution {
    String[] alphabet = {"A","E","I","O","U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("", 0);
        
        for(int i=0; i<list.size(); i++){
            if(word.equals(list.get(i))){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
    
    public void dfs(String str, int depth){
        if(depth==5){
            return;
        }
        for(int i=0; i<5; i++){
            String next = str + alphabet[i];
            list.add(next);
            dfs(next, depth+1);
        }
    }
}