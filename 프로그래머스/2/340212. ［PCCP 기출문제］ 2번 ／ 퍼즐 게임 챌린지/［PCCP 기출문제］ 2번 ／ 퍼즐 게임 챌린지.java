import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = 100000;
        int mid=0;
        
        long time;
        
        while(left <= right){
            time = 0;
            time += times[0];
            
            mid = left + (right - left)/2;
            
            for(int i=1; i<diffs.length; i++){
                int diff = diffs[i];
                int time_cur = times[i];
                int time_prev = times[i-1];
                     
                if(diff > mid){
                    time += (long)(diff - mid)*(time_prev+time_cur) + time_cur;
                }
                else{
                    time += time_cur;
                }
            }
            
            if(time>limit){
                left = mid+1; 
            }else if(time<=limit){
                right = mid-1;
            }
        }
        
        return left;
    }
}