import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];
        for(int i=0; i<3; i++){
            maxDp[0][i] = arr[0][i];
            minDp[0][i] = arr[0][i];
        }
        
        for(int i=1; i<N; i++){
            maxDp[i][0] = arr[i][0] + Math.max(maxDp[i-1][0], maxDp[i-1][1]);
            maxDp[i][1] = arr[i][1] + Math.max(maxDp[i-1][0], Math.max(maxDp[i-1][1], maxDp[i-1][2]));
            maxDp[i][2] = arr[i][2] + Math.max(maxDp[i-1][1], maxDp[i-1][2]);
            
            minDp[i][0] = arr[i][0] + Math.min(minDp[i-1][0], minDp[i-1][1]);
            minDp[i][1] = arr[i][1] + Math.min(minDp[i-1][0], Math.min(minDp[i-1][1], minDp[i-1][2]));
            minDp[i][2] = arr[i][2] + Math.min(minDp[i-1][1], minDp[i-1][2]);
        }
        
        int maxN=0, minN=Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(maxN<maxDp[N-1][i]) maxN = maxDp[N-1][i];
            if(minN>minDp[N-1][i]) minN = minDp[N-1][i];
        }
        
        System.out.println(maxN+" "+minN);
        
    }
}