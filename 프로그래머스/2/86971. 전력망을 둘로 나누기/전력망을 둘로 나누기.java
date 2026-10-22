import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> adj = new LinkedList<>();
        
        // 인접리스트 생성
        for(int i=0; i<=n; i++){
            adj.add(new LinkedList<>());
        }
        
        for(int i=0; i<wires.length; i++){
            adj.get(wires[i][1]).add(wires[i][0]);
            adj.get(wires[i][0]).add(wires[i][1]);
        }
        
        // 모든 간선 제거해보기
        int nodeNum = 0;
        int answer = n;
        for(int[] wire : wires){
            adj.get(wire[0]).remove(Integer.valueOf(wire[1]));
            adj.get(wire[1]).remove(Integer.valueOf(wire[0]));
            
            nodeNum = countNode(adj, wire[0], n);
            answer = Math.min(answer, Math.abs(2*nodeNum - n));
            
            adj.get(wire[1]).add(wire[0]);
            adj.get(wire[0]).add(wire[1]);
        }
        
        return answer;
    }
    
    // 연결된 노드 개수 세기
    public int countNode(List<List<Integer>> adj, int nodeNum, int nodeCnt){
        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[nodeCnt+1];
        int cnt = 1;
        
        q.add(nodeNum);
        checked[nodeNum] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int n : adj.get(node)){
                if(!checked[n]){
                    q.add(n);
                    checked[n]=true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}