import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1]!=b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        List<int[]> jobList = new ArrayList<>();
        
        for(int i=0; i<jobs.length; i++){
            jobList.add(new int[]{jobs[i][0],jobs[i][1], i});
        }
        
        jobList.sort((a,b) -> Integer.compare(a[0],b[0]));
        
       
        int curTime = 0;
        int time = 0;
        int idx=0;
        while (idx < jobs.length || !pq.isEmpty()) {
            // 현재 시각까지 요청된 작업을 pq에 넣기
            while(idx < jobs.length &&curTime>=jobList.get(idx)[0]){
                pq.add(new int[]{jobList.get(idx)[0], jobList.get(idx)[1], jobList.get(idx)[2]});
                idx++;
            }
            
            // pq가 비어 있다면 다음 작업의 요청 시각으로 이동
            if(pq.isEmpty()){
                curTime = jobList.get(idx)[0];
                continue;
            }

            // pq에서 작업 하나를 꺼내 처리하기
            int[] cur = pq.poll();
            curTime += cur[1];
            time += curTime - cur[0];
        }
        
        return time/jobs.length;
    }
}