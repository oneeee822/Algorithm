import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            list[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(list, (a, b)-> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }
        
        if (list[0].equals("0")) return "0";
        
        return sb.toString();
    }
}