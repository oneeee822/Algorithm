import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main
{
    public static int N, M, K;
    public static int R,C;
	public static int notebook[][];
	public static int sticker[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		
		notebook = new int[N][M];
		
		for(int k=0; k<K; k++){
		    st = new StringTokenizer(br.readLine());
		    R = Integer.parseInt(st.nextToken());
		    C = Integer.parseInt(st.nextToken());
		    
		    sticker = new int[12][12];
		    
		    for(int i=0; i<R; i++){
		        st = new StringTokenizer(br.readLine());
		        for(int j=0; j<C; j++){
		            sticker[i][j] = Integer.parseInt(st.nextToken());
		        }   
		    }
		    check();
		}
		
		int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count += notebook[i][j];
            }
        }
        System.out.println(count);
	}
		
	public static void check(){
	    for(int rot=0; rot<4; rot++){
	        for(int i=0; i<=N-R; i++){
	            for(int j=0; j<=M-C; j++){
	                if(attach(i,j)){
		                return;
		            }
		        }
		    }
		    rotate();
	    }
	}
		
	public static boolean attach(int x, int y){
	    for(int i=0; i<R; i++){
	        for(int j=0; j<C; j++){
	            if(notebook[x+i][y+j]!=0 && sticker[i][j]==1) return false;
	        }
	    }
		    
	    for(int i=0; i<R; i++){
	        for(int j=0; j<C; j++){
	            if(sticker[i][j]==1){
	                notebook[x+i][y+j]=1;
	            }
	        }
	    }
	    return true;
    }
		
	public static void rotate(){
	    int temp[][] = new int[12][12];
		    
	    for(int i=0; i<R; i++){
	        System.arraycopy(sticker[i],0,temp[i],0,C);
	    }
		    
	    for(int i=0; i<C; i++){
	        for(int j=0; j<R; j++){
	            sticker[i][j]=temp[R-1-j][i];
	        }
	    }
	    
	    int tmp = R;
	    R = C;
	    C = tmp;
	}
}