import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main
{
    static int N, M;
    static int arr[], Narr[];
    static StringBuilder sb = new StringBuilder();
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
		
		func(0);
		System.out.println(sb);
	}
	
	public static void func(int k){
	    if(k==M){
	        for(int i=0; i<M; i++){
	            sb.append(arr[i] + " ");
	        }
	        sb.append("\n");
	        return;
	    }
	    
	    for(int i=0; i<N; i++){
	        arr[k] = Narr[i];
	        func(k+1);
	    }
	    
	}
}