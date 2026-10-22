import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        Queue<int[]> bridge = new LinkedList<>();
        
        for(int truck : truck_weights){
            q.add(truck);
        }
        
        int curTime = 0;
        int curWeight = q.peek();
        bridge.add(new int[] {bridge_length, q.poll()});
        
        while(!bridge.isEmpty()){
            // 다리에서 트럭 제거
            if(!bridge.isEmpty()){
                if(curTime>=bridge.peek()[0]) {
                    curWeight-=bridge.poll()[1];
                }
            }
            
            // 무게 남으면 트럭 다리에 올리기
            while(!q.isEmpty()&&q.peek()+curWeight<=weight){
                int carTruck = q.poll();
                bridge.add(new int[] {curTime+bridge_length, carTruck});
                curWeight += carTruck;
            }
            curTime++;
        }
        
        return curTime;
    }
}