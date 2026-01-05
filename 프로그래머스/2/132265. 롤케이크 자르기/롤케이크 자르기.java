import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> left = new HashMap<Integer, Integer>();
        Map<Integer,Integer> right = new HashMap<Integer, Integer>();
        
        for(int t: topping){
            right.put(t, right.getOrDefault(t, 0)+1);
        }
        
        for(int i=0; i<topping.length; i++){
            int t = topping[i];
            left.put(t, left.getOrDefault(topping[i], 0)+1);
            right.put(t, right.get(t)-1);
            
            if(right.get(t)==0) right.remove(t);
            
            
            if(left.size()==right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}