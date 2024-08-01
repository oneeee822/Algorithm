//큐없이 구현
import java.util.ArrayList;
import java.util.List;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        List<Integer> pq = new ArrayList<>();
        List<Integer> sq = new ArrayList<>();
        
        for(int i = 0; i< progresses.length; i++){
            pq.add(progresses[i]);
            sq.add(speeds[i]);
        }
        
        while(!pq.isEmpty()){
            while(pq.get(0)<100){
                for(int i = 0; i<pq.size(); i++){
                    pq.set(i, pq.get(i) + sq.get(i));
                }
            }
            int function = 0;
            while(!pq.isEmpty() && pq.get(0)>=100){
                pq.remove(0);
                sq.remove(0);
                function++;
            }
            
            if (function > 0) {
                answer.add(function);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
