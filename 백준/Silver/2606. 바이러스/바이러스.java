import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    
    static boolean[] check;
    static int[][] arr;
    static int cnt = 0;
    
    static int computers, edges;
    static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        computers = Integer.parseInt(br.readLine());
        edges = Integer.parseInt(br.readLine());
        
        arr = new int[computers+1][computers+1];
        check = new boolean[computers+1];
        
        for(int i =0; i<edges ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            arr[u][v] = arr[v][u] = 1;
        }
        
        dfs(1);
        System.out.println(cnt-1);
    }
    
    public static void dfs(int start){
        check[start] = true;
        cnt++;
        
        for(int i=0; i<=computers; i++){
            if(arr[start][i] ==1 && !check[i])
                dfs(i);
        }
    }
}