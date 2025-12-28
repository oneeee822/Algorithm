class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int j = 1;
        
        for(int i=1; i<=n; i++){
            while(sum<n){
                sum+=j; 
                j++;
            }
            if(sum==n){
                answer++;
            }
            sum-=i;
        }
        
        return answer;
    }
}