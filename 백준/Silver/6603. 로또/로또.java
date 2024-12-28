import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int T;
    static int arr[], Narr[];
    static boolean visited[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(); 

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            if(T==0) break;
            
            arr = new int[6];  
            Narr = new int[T]; 
            visited = new boolean[T]; 

          
            for (int i = 0; i < T; i++) {
                Narr[i] = Integer.parseInt(st.nextToken());
            }      
            
            func(0,0); 
            sb.append("\n"); 
        }

        System.out.print(sb.toString()); 
    }

    
    public static void func(int k, int start) {
        if (k == 6) { 
            for (int val : arr) {
                sb.append(val).append(" "); 
            }
            sb.append("\n"); 
            return; 
        }

        for (int i = start; i < T; i++) { 
            arr[k] = Narr[i];
            func(k + 1, i+1); 
            
        }
    }
}
