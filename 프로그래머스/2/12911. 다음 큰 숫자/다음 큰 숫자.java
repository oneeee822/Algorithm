import java.util.*;

class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        cnt = Integer.bitCount(n++);
        
        while(n<1000001){
            if(cnt==Integer.bitCount(n))
                return n;
            n++;
        }
        
        
        return n;
    }
}