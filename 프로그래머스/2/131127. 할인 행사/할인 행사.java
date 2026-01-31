import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wants = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            wants.put(want[i], number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++){
            Map<String, Integer> cart = new HashMap<>();
            for(int j=0; j<10; j++){
                cart.put((discount[i+j]), cart.getOrDefault(discount[i+j],0)+1);
            }
            boolean available = true;
            for(Map.Entry<String, Integer> e : wants.entrySet()){
                String product = e.getKey();
                if(!cart.containsKey(product) || cart.get(product) < (e.getValue())){
                    available = false;
                    break;
                }
            }
            if(available) answer++;
        }
        
        return answer;
    }
}