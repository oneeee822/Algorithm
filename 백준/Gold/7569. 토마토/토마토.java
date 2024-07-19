import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class ripe_tomato{
    int z;
    int y;
    int x;
    
    ripe_tomato(int z, int y, int x){
        this.z = z;
        this.y = y;
        this.x = x;
    }
}
public class Main{
    static int M, N, H;
    static int [][][] box;
    static int unripe = 0;
    static int days =0;
    static int [] dx = {0,0,1,-1,0,0};
    static int [] dy = {1,-1,0,0,0,0};
    static int [] dz = {0,0,0,0,1,-1};
    static Queue<ripe_tomato> ripe = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        
        
        for(int i = 0; i<H; i++){
            for(int j=0 ; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1){
                        ripe.add(new ripe_tomato(i,j,k));
                    }
                    else if(box[i][j][k]==0){
                        unripe++;
                    }
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    public static int bfs(){
        while(unripe>0 && !ripe.isEmpty()){
            int size = ripe.size();
            for(int i=0;i<size; i++){
                ripe_tomato t = ripe.remove();
                
                int z = t.z;
                int y = t.y;
                int x = t.x;
            
                for(int j = 0; j<6; j ++){
                    int nz = z + dz[j];
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                
                    if(nx>=0 && nx<M && ny>=0 && ny<N && nz>=0 && nz<H){
                        if(box[nz][ny][nx]==0){
                            unripe--;
                            box[nz][ny][nx] = 1;
                            ripe.add(new ripe_tomato(nz,ny,nx));
                        }
                    }
                }
            }
            days++;
        }
        return unripe == 0 ? days : -1;
        
    }
}