import java.util.*;

class Solution {
    int[] parent = new int[100];
    
    public int solution(int n, int[][] costs) {
        int answer = 0;

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));

        int edge = 0;
        for(int i=0; i<costs.length; i++){
            if(edge==n-1) break;
            
            if(union(costs[i][0], costs[i][1])){
                edge++;
                answer += costs[i][2];
            }
            
        }
        return answer;
    }
    
    public boolean union(int i, int j){
        int rootA = find(i);
        int rootB = find(j);
        
        if(rootA!=rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }
    
    public int find(int i){
        if(parent[i]==i) return i;
        return find(parent[i]);
    }
}