import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> q = new ArrayDeque<>();
        
        if(cacheSize==0) return 5*cities.length;
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            
            if(q.contains(city)){ // 캐시히트라면
                q.remove(city);
                q.add(city);
                answer++;
            }
            
            else{ // 캐시 히트가 아니라면
                if(q.size()==cacheSize){ // 캐시가 다 찼을 때
                    q.poll();
                    q.add(city);
                    answer+=5;
                }
                else{
                    q.add(city);
                    answer+=5;
                }
            }
        }
        return answer;
    }
}