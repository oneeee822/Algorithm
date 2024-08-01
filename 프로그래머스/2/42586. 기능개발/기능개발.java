import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        int day = 0 ;
        
        for(int i = 0; i< progresses.length; i++){
            if((100-progresses[i])%speeds[i]==0){
                day = (100-progresses[i])/speeds[i];
            }
            else{
                day = (100-progresses[i])/speeds[i] + 1;
            }
            
            q.add(day);
        }
        
        int functions = 0;
        day = q.peek();
        
        while(!q.isEmpty()){
            
            if(q.peek()<=day){
                functions++;
                q.poll();
            }
            else {
				answer.add(functions);
				functions = 1;
				day = q.poll(); 
			}
        }
        answer.add(functions);
        return answer.stream().mapToInt(i->i).toArray();
    }
}