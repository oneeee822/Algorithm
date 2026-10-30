import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int answer = 0;
        
        map.put("zero", 0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        String numStr = "";
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))) result.add(s.charAt(i)-'0');
            else{
                numStr += s.charAt(i);
                if(map.containsKey(numStr)){
                    result.add(map.get(numStr));
                    numStr = "";
                }
            }
        }
        for(int i : result){
            answer = answer*10 + i;
        }
        return answer;
    }
}