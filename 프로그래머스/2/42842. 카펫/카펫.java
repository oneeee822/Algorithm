class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        if(yellow==1){
            answer[0] = 3;
            answer[1] = 3;
            return answer;
        }
        
        for(int i=1; i<=yellow/2; i++){
            if(yellow%i==0){
                if(brown+yellow == (i+2)*(yellow/i + 2)){
                    answer[0] = Math.max((i+2),(yellow/i +2));
                    answer[1] = Math.min((i+2),(yellow/i +2));
                }
            }
        }
        return answer;
    }
}