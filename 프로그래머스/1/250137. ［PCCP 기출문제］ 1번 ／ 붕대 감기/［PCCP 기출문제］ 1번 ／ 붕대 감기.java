class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int initial = health;
        int b = 0;
        int j = 0;
        for(int i=1; i<=attacks[attacks.length-1][0]; i++){
            if(i==attacks[j][0]){
                b = 0;
                health -= attacks[j][1];
                if(health<=0) return -1;
                j++;
            }
            else{
                b++;
                health += bandage[1];
                
                if(b==bandage[0]){
                    health+=bandage[2];
                    b=0;
                }
                
                if(health>initial) health = initial;
            }
        }
        return health;
    }
}