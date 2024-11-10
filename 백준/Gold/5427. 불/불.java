import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int w, h;
    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            maze = new char[h][w];
            visited = new boolean[h][w];
        
            Queue<int[]> fireQ = new LinkedList<>();
            Queue<int[]> q = new LinkedList<>();
            
            for(int j = 0; j < h; j++) {
                String line = br.readLine();
                for(int k = 0; k < w; k++) {
                    maze[j][k] = line.charAt(k);
                    if(maze[j][k] == '@') {
                        q.add(new int[] {j, k});
                        visited[j][k] = true;
                    }
                    else if(maze[j][k] == '*') {
                        fireQ.add(new int[] {j, k});
                    }
                }
            }
            
            int answer = bfs(q, fireQ);
            if(answer == -1){
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }
    
    public static int bfs(Queue<int[]> q, Queue<int[]> fireQ) {
        int time = 0;
        
        while (!q.isEmpty()) {
            time++; 
            
            int fireSize = fireQ.size();
            for(int f = 0; f < fireSize; f++) {
                int[] fire = fireQ.poll();
                int fx = fire[0];
                int fy = fire[1];
                
                for (int i = 0; i < 4; i++) {
                    int nx = fx + dx[i];
                    int ny = fy + dy[i];
                    
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && maze[nx][ny] == '.') {
                        maze[nx][ny] = '*';
                        fireQ.add(new int[] {nx, ny});
                    }
                }
            }
            
            int size = q.size();
            for(int p = 0; p < size; p++) {
                int[] person = q.poll();
                int px = person[0];
                int py = person[1];
                
                for (int i = 0; i < 4; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {  // Exit found
                        return time;
                    }
                    if (maze[nx][ny] == '.' && !visited[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}