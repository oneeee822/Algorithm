import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String num:phone_book){
            hm.put(num,1);
        }
        
        for(String num:phone_book){
            for(int j=1;j<num.length();j++){
                if(hm.containsKey(num.substring(0,j))){
                    return false;
                }
            }
        }
        return true;
    }
}