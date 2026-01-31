import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        int[] elementList = new int[elements.length*2];
        
        for(int i=0; i<elementList.length; i++){
            elementList[i] = elements[i%elements.length];
        }
        
        for(int i=0; i<elements.length; i++){
            int sum = 0;
            for(int j=0; j<elements.length; j++){
                sum += elementList[i+j];
                answer.add(sum);
            }
        }
        return answer.size();
    }
}