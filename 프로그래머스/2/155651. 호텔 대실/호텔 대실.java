import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<List<Integer>> startTimePq = new PriorityQueue<>((a,b) -> Integer.compare(a.get(0), b.get(0)));
        PriorityQueue<List<Integer>> endTimePq = new PriorityQueue<>((a,b) -> Integer.compare(a.get(1), b.get(1)));
        
        // 큐에 대실 시작순으로 저장
        for(String[] book : book_time){
            List<Integer> bookTime = new ArrayList<>();
            for(String b : book){
                String[] time = b.split(":");
                bookTime.add(Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
            }
            startTimePq.add(bookTime);
        }
        
        endTimePq.add(startTimePq.poll());
        int room=1;
        while(!startTimePq.isEmpty()){
            List<Integer> curRoom = startTimePq.peek();
            // 대실할 수 없으면
            if(endTimePq.peek().get(1) + 10 > curRoom.get(0)){
                room++;
            }
            else{
                endTimePq.poll();
            }
            endTimePq.add(startTimePq.poll());
        }
    
        return room;
    }
}