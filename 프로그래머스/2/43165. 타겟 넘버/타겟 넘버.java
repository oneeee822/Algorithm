class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, target, 0, numbers);

        return answer;
    }
    
    public void dfs(int i, int target, int result, int[] numbers){
        if(i == numbers.length){
            if(result==target)
                answer++;
            return;
        }
        
        dfs(i+1, target, result+numbers[i], numbers);
        dfs(i+1, target, result-numbers[i], numbers);
    }
}