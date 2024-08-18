import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++)
            arr[i]= String.valueOf(numbers[i]);
        
        
        Arrays.sort(arr, (s1, s2)->(s2+s1).compareTo(s1+s2));
        
        for(int i = 0; i<numbers.length; i++)
            answer+=arr[i];
        
        
        if(answer.charAt(0)=='0')
            answer = "0";
        
        return answer;
    }
}