import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];

        for(int i=0; i<progresses.length; i++){
            days[i] = (100-progresses[i]+speeds[i]-1)/speeds[i];
        }

        int current = days[0];
        int cnt = 1;

        for(int i=1; i<days.length; i++){
            if(days[i] <= current){
                cnt++;
            } else {
                answer.add(cnt);
                current = days[i];
                cnt = 1;
            }
        }

        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}