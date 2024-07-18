import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static int M, N;
    static int [][] box;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        
        for(int i=0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    public static int bfs(){
        while(!q.isEmpty()){
            int[] tomato = q.poll();
            int x = tomato[0];
            int y = tomato[1];
            
            for(int i = 0; i<4; i ++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(box[nx][ny]==0){
                        box[nx][ny] = box[x][y] +1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(box[i][j]==0)
                    return -1;
                else{
                    if (max < box[i][j]) {
                        max = box[i][j];
                    }
                }
            }
        }
        
        return max - 1;
        
    }
}