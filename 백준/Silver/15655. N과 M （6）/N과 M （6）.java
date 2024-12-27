import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main
{
    static int N, M;
    static int arr[], Narr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Narr = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        Narr[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(Narr);
		
		func(0,0);
	}
	
	public static void func(int start, int depth){
	    if(depth==M){
	        for(int i=0; i<M; i++){
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	        return;
	    }
	    
	    for(int i=start; i<N; i++){
	        arr[depth] = Narr[i];
	        func(i+1, depth+1);
	    }
	    
	}
}