import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for(int i=0; i<A.length; i++){
            a.add(A[i]);
            b.add(B[i]);
        }
        
        while(!a.isEmpty()){
            int curA = a.poll();
            while(!b.isEmpty()){
                if(curA<b.peek()) {
                    b.poll();
                    answer++;
                    break;
                }
                else{
                    break;
                }
            }
        }
        
        return answer;
    }
}