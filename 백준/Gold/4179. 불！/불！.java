import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int R, C;
    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R][C];
        visited = new boolean[R][C];
        
        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jihoonQueue = new LinkedList<>();
        
        int si = 0, sj = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'J') {
                    si = i;
                    sj = j;
                    jihoonQueue.add(new int[]{si, sj});
                    visited[si][sj] = true;
                }
                if (maze[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }

        int answer = bfs(jihoonQueue, fireQueue);
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static int bfs(Queue<int[]> jihoonQueue, Queue<int[]> fireQueue) {
        int time = 0;

        while (!jihoonQueue.isEmpty()) {
            time++;

            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                int[] fire = fireQueue.poll();
                int fx = fire[0];
                int fy = fire[1];

                for (int d = 0; d < 4; d++) {
                    int nfx = fx + dx[d];
                    int nfy = fy + dy[d];

                    if (nfx >= 0 && nfx < R && nfy >= 0 && nfy < C && maze[nfx][nfy] == '.') {
                        maze[nfx][nfy] = 'F';
                        fireQueue.add(new int[]{nfx, nfy});
                    }
                }
            }

            int jihoonSize = jihoonQueue.size();
            for (int i = 0; i < jihoonSize; i++) {
                int[] jihoon = jihoonQueue.poll();
                int jx = jihoon[0];
                int jy = jihoon[1];

                if (jx == 0 || jy == 0 || jx == R - 1 || jy == C - 1) {
                    return time;
                }

                for (int d = 0; d < 4; d++) {
                    int njx = jx + dx[d];
                    int njy = jy + dy[d];

                    if (njx >= 0 && njx < R && njy >= 0 && njy < C &&
                        maze[njx][njy] == '.' && !visited[njx][njy]) {
                        visited[njx][njy] = true;
                        jihoonQueue.add(new int[]{njx, njy});
                    }
                }
            }
        }
        return -1; 
    }
}