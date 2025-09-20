class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] dpFirst = new int[sticker.length];
        int[] dpLast = new int[sticker.length];
        
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        dpFirst[0] = sticker[0];
        dpFirst[1] = sticker[0];
        for(int i=2; i<sticker.length-1; i++){
            dpFirst[i] = Math.max(dpFirst[i-2]+ sticker[i], dpFirst[i-1]);
        }
        
        dpLast[0] = 0;
        dpLast[1] = sticker[1];
        for(int i=2; i<sticker.length; i++){
            dpLast[i] = Math.max(dpLast[i-2]+ sticker[i], dpLast[i-1]);
        }

        return Math.max(dpFirst[sticker.length-2], dpLast[sticker.length-1]);
    }
}