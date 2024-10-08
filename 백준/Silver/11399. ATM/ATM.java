import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		// 입력의 범위 1 ~ 1000이므로 1001개
		int[] arr = new int[1001];
        
        while(N-->0){
            arr[Integer.parseInt(st.nextToken())]++;
        }
        
        int prev = 0;	// 이전까지의 대기시간 누적합
		int sum = 0;	// 사람별 대기시간 총합
		
		for (int i = 0; i < 1001; i++) {
			
			//배열 뒤 원소부터
			while (arr[i]-- > 0) {
				sum += (i + prev);
				prev += i;
			}
		}
		System.out.println(sum);
	}
}
