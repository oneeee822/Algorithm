import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  
    static int l;
    static int x,y, dest_x, dest_y;
    static int[][] board;
    static boolean[][] check;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i =0; i<T; i++){
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            check = new boolean[l][l];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            dest_x = Integer.parseInt(st.nextToken());
            dest_y = Integer.parseInt(st.nextToken());
            
            bfs();
            
            sb.append(board[dest_x][dest_y]).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        check[x][y]=true;
        
        while(!q.isEmpty()){
            int[] present = q.poll();
            int px = present[0];
            int py = present[1];
            
            for(int i =0 ; i<8; i++){
                int next_x = px + dx[i];
                int next_y = py + dy[i];
                
                if(next_x >= 0 && next_y >= 0 && next_x<l && next_y<l){
                    if(!check[next_x][next_y]){
                        q.add(new int[] {next_x,next_y});
                        board[next_x][next_y] = board[px][py] + 1;
                        check[next_x][next_y] = true;
                    }
                }
            }
        }
        
    }
    
    
}