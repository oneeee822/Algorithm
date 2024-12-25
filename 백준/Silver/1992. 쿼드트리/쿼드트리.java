import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int video[][]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(compress(0, 0, N));
    }

    public static String compress(int x, int y, int N) {
        if (check(x, y, N)) {
            return String.valueOf(video[x][y]);
        }

        int newSize = N / 2;
        String topLeft = compress(x, y, newSize);
        String topRight = compress(x, y + newSize, newSize);
        String bottomLeft = compress(x + newSize, y, newSize);
        String bottomRight = compress(x + newSize, y + newSize, newSize);

        return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
    }

    public static boolean check(int x, int y, int N) {
        int value = video[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (video[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}