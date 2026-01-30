import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        
        char prev = words[0].charAt(words[0].length()-1);
        wordSet.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            String word = words[i];
            
            if(wordSet.contains(word) || prev!=word.charAt(0)){
                int person = (i%n) + 1;
                int turn = i/n +1;
                
                return new int[] {person, turn};
            }
            else{
                wordSet.add(words[i]);
            }
            
            prev = word.charAt(word.length()-1);
        }

        return new int[] {0,0};
    }
}