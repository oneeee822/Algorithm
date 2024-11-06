import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int n, m;
	static int[][] pic;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		pic = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<m; j++){
		        pic[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		int max = 0;
		int num = 0;
		for(int i=0; i<n; i++){
		    for(int j=0; j<m; j++){
		        if(!visited[i][j] && pic[i][j]==1){
		            int cnt = bfs(i, j);
		            max = Math.max(max, cnt);
		            num++;
		        }
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.append(num).append("\n").append(max));
	}
	
	public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (pic[nx][ny] != 1 || visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true; 
                cnt++;
            }
        }

        return cnt;
    }
}