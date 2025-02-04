import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[10];
		
		 if (n == 1) {
            System.out.println(10);
            return;
        }
		
		for(int j=0; j<10; j++){
		    arr[j] = 1;
		}
		
		for(int i=1; i<n; i++){
		    for(int j=1; j<10; j++){
		        arr[j] = (arr[j-1] + arr[j]) % 10007;
		    }
		}
		
		int result = 0;
		for(int j=0; j<10; j++){
		  result = (result + arr[j])%10007;
		}
		System.out.println(result);
		
	}
}