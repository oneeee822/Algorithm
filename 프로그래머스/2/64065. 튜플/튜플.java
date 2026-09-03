import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        
        s = s.replaceAll("[{}]","");
        String[] arr = s.split(",");
        
        for(int i=0; i<arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).getKey();
        }
        
        return answer;
    }
}