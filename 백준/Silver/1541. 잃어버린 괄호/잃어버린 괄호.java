import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] sub = input.split("-");
 
        int answer = mSum(sub[0]);

        for (int i = 1; i < sub.length; i++) {
            int temp = mSum(sub[i]);
            answer -= temp; 
        }
        
        System.out.println(answer);
    }
    
    static int mSum(String s) {
        int sum = 0;

        String[] temp = s.split("\\+");

        for (String num : temp) {
            sum += Integer.parseInt(num);
        }
        
        return sum;
    }
}