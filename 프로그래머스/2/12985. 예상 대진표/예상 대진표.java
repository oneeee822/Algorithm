class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        a--;
        b--;
        while(true){
            answer++;
            if((a/=2)==(b/=2)){
                break;
            }
        }
        return answer;
    }
}