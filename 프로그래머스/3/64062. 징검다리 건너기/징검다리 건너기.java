class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        
        for(int s : stones){
            if(max<s) max = s;
        }
        
        int left = 0; 
        int right = max;
        while(left<=right){
            
            int zero = 0;
            boolean fail = false;
            int mid = (left+right)/2;
            
            for(int s : stones){
                if(s<mid){
                    zero++;
                    if(zero>=k) {
                        fail = true;
                        break;
                    }
                }
                else{
                    zero = 0;
                }
            }
            
            if(fail){
                right = mid - 1;
            }
            else{
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
}