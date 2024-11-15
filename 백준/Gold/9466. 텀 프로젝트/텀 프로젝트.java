import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int[] student;
    static boolean[] team;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); 
            student = new int[n + 1];
            team = new boolean[n + 1];
            visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                student[i] = Integer.parseInt(st.nextToken()); 
            }

            cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!team[i]) { 
                    dfs(i);
                }
            }
            System.out.println(n-cnt);
        }
    }

    public static void dfs(int index) {
        if(team[index]) return;
        
        if(visited[index]){
            team[index]=true;
            cnt++;
        }
        
        visited[index] = true;
        
        dfs(student[index]);
        
        team[index] = true;
        visited[index] = false;

    }
}