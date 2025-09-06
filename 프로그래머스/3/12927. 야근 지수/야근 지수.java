import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works){
            pq.add(w);
        }
        
        while(n>0 && !pq.isEmpty()){
            int max = pq.poll();
            if(max>0){
                max-=1;
                pq.add(max);
            }
            n--;
        }
        
        while(!pq.isEmpty()){
            int x = pq.poll();
            answer+= x*x;
        }
        return answer;
    }
}