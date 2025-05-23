import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static char arr[][]; 
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0;i<N;i++)
			Arrays.fill(arr[i],' ');

        star(0,0,N);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int n) {
        
        if(n==1) {
			arr[x][y]='*';
			return;
        }
        
        int newSize = n/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i==1 && j==1))
                    star(x+i*newSize, y+j*newSize, newSize);
            }
        }
    }
}