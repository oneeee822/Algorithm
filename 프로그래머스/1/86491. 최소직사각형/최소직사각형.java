import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        HashSet<Integer> wSet = new HashSet<>();
        HashSet<Integer> hSet = new HashSet<>();
        
        for(int[] size : sizes){
            if(size[0]>size[1]){
                wSet.add(size[0]);
                hSet.add(size[1]);
            }
            else{
                wSet.add(size[1]);
                hSet.add(size[0]);
            }
        }
        
        int w = Collections.max(wSet);
        int h = Collections.max(hSet);
        
        return w*h;
    }
}