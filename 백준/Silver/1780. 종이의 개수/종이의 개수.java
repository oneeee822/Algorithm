import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int minus, zero, one;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        papernum(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void papernum(int x, int y, int size) {
        
        if(check(x,y,size)){
            if (paper[x][y] == -1) minus++;
            else if (paper[x][y] == 0) zero++;
            else one++;
            return;
        }
        
        int newSize = size/3;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                papernum(x+i*newSize, y+j*newSize, newSize);
            }
        }
        
    }
    
    public static boolean check(int x, int y, int size){
        int value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != value) return false;
            }
        }
        return true;
    }
}