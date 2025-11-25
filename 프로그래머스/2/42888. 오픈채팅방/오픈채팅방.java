import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        
        for(String s : record){
            String[] str  = s.split(" ");
            if(str[0].equals("Enter") || str[0].equals("Change")){
                hm.put(str[1], str[2]);
            }       
        }
        
        for(String s : record){
            String[] str  = s.split(" ");
            if(str[0].equals("Enter")){
                answer.add(hm.get(str[1])+"님이 들어왔습니다.");
            }
            else if(str[0].equals("Leave")){
                answer.add(hm.get(str[1])+"님이 나갔습니다.");
            }
        }
        
      
        return answer.toArray(new String[0]);
    }
}