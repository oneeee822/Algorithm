import java.util.*;

class Solution {
    static Set<Integer> answer = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        String[] numList = numbers.split("");
        
        for(int i=0; i<numList.length; i++){
            visited = new boolean[numList.length];
            
            visited[i] = true;
            dfs(numList, numList[i]);
        }
            
        return answer.size();
    }
    
    public void dfs(String[] numList, String num){
        checkPrime(Integer.parseInt(num));
 
        for(int i=0; i<numList.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numList, num+numList[i]);
            visited[i] = false;
        }
    }
    
    // 소수인지 확인
    public void checkPrime(int n){
        if(n<2) return;
        
        for(int i=2; i<n; i++){
            if(n%i==0) return;
        }
        
        answer.add(n);
    }
}