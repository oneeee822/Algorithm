import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int [] answer1 = {-1};
        
        if(s<n)
            return answer1;
        
        int remain = s % n;
        
        for(int i=0; i<n; i++){
            
            answer[i] = (remain==0) ? s/n : (i<remain) ? s/n+1 : s/n;
        }
    
        Arrays.sort(answer);
            
        return answer;
    }
}