import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static char[][] puyo = new char[12][6];
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int chainCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       
        for (int i = 0; i < 12; i++) {
            puyo[i] = br.readLine().toCharArray();
        }

        while (true) {
            boolean exploded = false; 
            visited = new boolean[12][6];
            
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (puyo[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j, puyo[i][j])) {
                            exploded = true;
                        }
                    }
                }
            }

            if (!exploded) break;
            
            dropPuyo();

            chainCount++; 
        }

        System.out.println(chainCount);
    }

    public static boolean bfs(int x, int y, char color) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> group = new LinkedList<>();
        q.add(new int[]{x, y});
        group.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue; 
                if (puyo[nx][ny] == color && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    group.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if (group.size() >= 4) {
            for (int[] pos : group) {
                puyo[pos[0]][pos[1]] = '.';
            }
            return true;
        }

        return false;
    }

    public static void dropPuyo() {
        for (int j = 0; j < 6; j++) {
            int emptyRow = 11; 
            for (int i = 11; i >= 0; i--) {
                if (puyo[i][j] != '.') {
                    puyo[emptyRow--][j] = puyo[i][j];
                }
            }
   
            for (int i = emptyRow; i >= 0; i--) {
                puyo[i][j] = '.';
            }
        }
    }
}
