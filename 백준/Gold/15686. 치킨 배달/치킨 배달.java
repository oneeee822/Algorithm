import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

class Point{
    int x; 
    int y;
    
    public Point(int x, int y){
        this.x = x; 
        this.y = y;
    }
}
public class Main
{
    static int N,M;
    static int map[][];
    static Point open[];
    static ArrayList<Point> houselist = new ArrayList<>();
    static ArrayList<Point> chickenlist = new ArrayList<>();
    static int answer=Integer.MAX_VALUE;;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		open = new Point [M];
		
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		        if(map[i][j]==1){
		            houselist.add(new Point(i,j));
		        }
		        else if(map[i][j]==2){
		            chickenlist.add(new Point(i,j));
		        }
		    }
		}
		
		dfs(0,0);
		System.out.println(answer);
		
	}
	
	public static void dfs(int depth, int start){
	    if(depth==M){
	        chickenDistance();
	        return;
	    }
	    
	    for(int i=start; i<chickenlist.size(); i++){
	        open[depth] = chickenlist.get(i);
	        dfs(depth+1, i + 1);
	    }
	}
	
	public static void chickenDistance(){
	    int result = 0;
	    for (Point house : houselist){
	        int distance = Integer.MAX_VALUE;
	        for (Point chicken : open) {
                int temp = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                distance = Math.min(distance, temp);
            }
	        result += distance;
	    }
	    answer = Math.min(answer, result);
	}
}