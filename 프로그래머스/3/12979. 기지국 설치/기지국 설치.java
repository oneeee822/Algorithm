class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = 0;
        int distance = 2*w + 1;
   
        len = stations[0] - w - 1;
        if(len>0){
                answer += (len + distance - 1)/distance;
        }
        
        for(int i=1; i<stations.length; i++){
            
           len = stations[i] - stations[i-1] - distance;
            if(len>0){
                answer += (len + distance - 1)/distance;
            }
            
        }
        
        len = n - stations[stations.length-1] - w ;
        if(len>0){
                answer += (len + distance - 1)/distance;
        }
        
        return answer;
    }
}