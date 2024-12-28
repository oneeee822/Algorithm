import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int arr[], Narr[];
    static boolean visited[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];  
        Narr = new int[N]; 
        visited = new boolean[N]; 
        sb = new StringBuilder(); 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Narr); 
        func(0,0);
        System.out.println(sb);
    }

    public static void func(int k, int start) {
        if (k == M) { 
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return; 
        }

        int before = 0; 
        for (int i = start; i < N; i++) { 
            if (before != Narr[i]) { 
                arr[k] = Narr[i]; 
                before = Narr[i]; 
                func(k+1, i); 
            }
        }
    }
}