import java.util.*;

class Solution {
    Map<String, Integer> mp = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new LinkedList<>();
        
        for(int i=0; i<course.length; i++){
            for(String s : orders){
                char[] charArray = s.toCharArray();
                Arrays.sort(charArray);
                dfs("", new String(charArray), course[i], 0);
            }
        }
        
        for (int i = 0; i < course.length; i++) {
            int max = 0;

            for (String key : mp.keySet()) {
                if (key.length() == course[i]) {
                    max = Math.max(max, mp.get(key));
                }
            }

            if (max >= 2) {
                for (String key : mp.keySet()) {
                    if (key.length() == course[i] && mp.get(key) == max) {
                        answer.add(key);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String combination, String s, int course, int startIdx){
        if(combination.length()==course){
            mp.put(combination, mp.getOrDefault(combination, 0)+1);
            return;
        }
        
        for(int i=startIdx; i<s.length(); i++){
            dfs(combination+s.charAt(i), s, course, i+1);
        }
    }
}