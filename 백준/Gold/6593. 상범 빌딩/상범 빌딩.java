import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L,R,C;
    static char[][][] building;
    static boolean[][][] visited;
    static int dx[] = {0,0,0,0,-1,1};
    static int dy[] = {0,0,1,-1,0,0};
    static int dz[] = {1,-1,0,0,0,0};
    static int sx,sy,sz,ex,ey,ez;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		
		while(true){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    
		    L = Integer.parseInt(st.nextToken());
		    R = Integer.parseInt(st.nextToken());
		    C = Integer.parseInt(st.nextToken());
		    
		    if(L==0 && R==0 && C==0) break;
		
		    building = new char[L][R][C];
		    visited = new boolean[L][R][C];
		    
		    for(int i=0; i<L; i++){
		        for(int j=0; j<R; j++){
		            String line = br.readLine();
		            for(int k=0; k<C; k++){
		                building[i][j][k] = line.charAt(k);
		                if (building[i][j][k] == 'S') {
                            sx = j; sy = k; sz = i; 
                        } else if (building[i][j][k] == 'E') {
                            ex = j; ey = k; ez = i;  
                        }
		            }
		        }
		        br.readLine();
		    }
		    
		    int minute = bfs(sx,sy,sz,ex,ey,ez);
		    if(minute==-1){
		        sb.append("Trapped!").append("\n");
		    }
		    else{
		        sb.append("Escaped in ").append(minute).append(" minute(s).").append("\n");
		    }
		}
		System.out.println(sb);
	}
	
	public static int bfs(int sx,int sy,int sz,int ex,int ey,int ez){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {sz,sx,sy});
	    visited[sz][sx][sy] = true;
	    
	    int minute = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] current = q.poll();
                
                if(current[0]==ez && current[1]==ex && current[2]==ey){
                    return minute;
                }
                
                for(int j=0; j<6; j++){
	                int curz = current[0]+dz[j];
	                int curx = current[1]+dx[j];
	                int cury = current[2]+dy[j];
	        
	                if(curx<0 ||cury<0 ||curz<0 ||curz>=L ||curx>=R ||cury>=C) continue;
	                if(building[curz][curx][cury]!='#'&& !visited[curz][curx][cury]){
	                    q.add(new int[] {curz,curx,cury});
	                    visited[curz][curx][cury] = true;
	                }
	            }
            }
            minute++;
        }
        return -1;
	}
}