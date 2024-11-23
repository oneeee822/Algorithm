import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main
{
    public static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int K = Integer.parseInt(br.readLine());
		
		System.out.println((1<<K)-1);
		func(1,3,K);
		System.out.println(sb);
	}
	
	public static void func(int a, int b, int n){
	    if(n==1){
	        sb.append(a+" "+b+"\n");
	        return;
	    }
	    func(a, 6-a-b, n-1);
	    sb.append(a+" "+b+"\n");
	    func(6-a-b, b, n-1);
	}
}