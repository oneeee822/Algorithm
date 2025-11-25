import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, String> inMap = new HashMap<>();
        Map<String, Integer> result = new TreeMap<>();
        
        for(String s : records){
            String[] str = s.split(" ");
            if(str[2].equals("IN")){
                inMap.put(str[1], str[0]);
            }
            else{
                String[] inTime = (inMap.get(str[1])).split(":");
                String[] outTime = str[0].split(":");
                
                int in = Integer.parseInt(inTime[0])*60 + Integer.parseInt(inTime[1]);
                int out = Integer.parseInt(outTime[0])*60 + Integer.parseInt(outTime[1]);
                
                int duration = out - in;
                
                if(result.containsKey(str[1])){
                    duration += result.get(str[1]);
                }
                
                result.put(str[1], duration);
                
                inMap.remove(str[1]);
            }
        }
        
        if(!inMap.isEmpty()){
            int duration = 0;
            for(Map.Entry<String, String> entry : inMap.entrySet()){
                String[] time = entry.getValue().split(":");
                duration = 23*60 + 59 - (Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
                
                result.put(entry.getKey(), result.getOrDefault(entry.getKey(),0)+duration);
            }
            
            
        }
        
        
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            int fee = 0;
            fee = fees[1];
            if(entry.getValue()>=fees[0]){
                fee += (int)Math.ceil((entry.getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }
            
            answer.add(fee);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}