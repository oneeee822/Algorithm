import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        
        for(int s : scoville){
            pq.add(s);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
   
            if(cur>=K) {
                pq.add(cur);
                break;
            }
            
            if(!pq.isEmpty()){
                int next = pq.poll();
                pq.add(cur + next*2);
                answer++;
            }
            else{
                return -1;
            }
        }
        
        return answer;
    }
}