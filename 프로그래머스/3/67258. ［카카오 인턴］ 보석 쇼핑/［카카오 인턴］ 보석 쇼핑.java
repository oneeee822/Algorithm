import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemList = new HashSet<>(Arrays.asList(gems));
        int gemNum = gemList.size();
        Map<String, Integer> map = new HashMap<>();
        
        int left=0;
        int minLength = Integer.MAX_VALUE;
        for(int right=0; right<gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
            
            while(map.size()==gemNum){
                if(right-left<minLength){
                    minLength = right-left;
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                
                map.put(gems[left], map.get(gems[left])-1);
                if(map.get(gems[left])==0){
                    map.remove(gems[left]);
                }
                left++;
            }
            
        }
        
        return answer;
    }
    
}