import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] Narr, arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Narr = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Narr);

        func(0);

        System.out.print(sb);
    }

    public static void func(int depth) {
 
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            
            if (before!=Narr[i]) { 
                visited[i] = true;
                arr[depth] = Narr[i]; 
                before = Narr[i];
                func(depth + 1); 
                visited[i] = false; 
            }
        }
    }
}
