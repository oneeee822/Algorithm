import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}

        dp[0] = arr[0];
        for(int i=0; i<N; i++){
            dp[i] = arr[i];
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
                 
            }
        }
        
        int result = 0;
        int max = Integer.MIN_VALUE;
        for(int i : dp){
            result = Math.max(i, result);
        }
        System.out.println(result);
	}

}