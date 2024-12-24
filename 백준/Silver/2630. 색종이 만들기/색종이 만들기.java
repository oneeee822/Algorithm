import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main
{
    static int paper[][];
    static int white, blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        paper[i][j]=Integer.parseInt(st.nextToken());
		    }
		}
		
		colorNum(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void colorNum(int x, int y, int N){
	    if(check(x,y,N)){
	        int value = paper[x][y];
	        if(value==0){
	            white ++;
	        }
	        else{
	            blue ++;
	        }
	        return;
	    }
	    
	    int newSize = N/2;
	    for(int i=0; i<2; i++){
	        for(int j=0; j<2; j++){
	            colorNum(x+i*newSize,y+j*newSize,newSize);
	        }
	    }
	    
	}
	
	public static boolean check(int x, int y, int N){
	    int value = paper[x][y];
	    for(int i=x; i<x+N; i++){
	        for(int j=y; j<y+N; j++){
	            if(value!=paper[i][j])
	                return false;
	        }
	    }
	    return true;
	}
}