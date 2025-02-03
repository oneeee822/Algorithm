import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    static int n, m, x, y;
    static int[] family;
    static boolean[] check;
    static List<Integer>[] relation ;
    static int result = -1;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		family = new int[n+1];
		check = new boolean[n+1];
		relation = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			relation[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		x =  Integer.parseInt(st.nextToken());
		y =  Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++){
		    st = new StringTokenizer(br.readLine());
		    int parent = Integer.parseInt(st.nextToken());
		    int child = Integer.parseInt(st.nextToken());
		    
		    relation[parent].add(child);
		    relation[child].add(parent);
		}
		
		dfs(x,y,0);
	    System.out.println(result);
		 
	}
	
	static void dfs(int s, int e, int cnt){
	    if(s==e){
	        result=cnt;
	        return;
	    }
	    
	    check[s] = true;
	    for(int i=0; i<relation[s].size(); i++){
	        if(!check[relation[s].get(i)]){
	            dfs(relation[s].get(i), e, cnt+1);
	        }
	    }
	}
}