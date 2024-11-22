import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static long C;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
	}
	
	public static long pow(long A, long B){
	    if(B==1) return A%C;
	    long temp = pow(A,B/2);
	    temp = temp*temp%C;
	    if(B%2==0) return temp;
	    return temp*A%C;
	}
}