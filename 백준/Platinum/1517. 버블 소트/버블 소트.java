import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static int[] arr, temp ;
    public static long cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        temp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        merge_sort(1,N);
        System.out.println(cnt);
        
    }
    
    public static void merge_sort(int s, int e){
        if(e-s<1){
            return;
        }
        
        int m = (s+e)/2;
        merge_sort(s,m);
        merge_sort(m+1,e);
        
        for(int i=s; i<=e; i++){
            temp[i]=arr[i];
        }
        
        int k = s;
        int idx1 = s;
        int idx2 = m+1;
        while(idx1<=m && idx2<=e){
            if(temp[idx1]>temp[idx2]){
                arr[k++]=temp[idx2++];
                cnt+=idx2-k;
            }
            else{
                arr[k++]=temp[idx1++];
            }
        }
        
        while(idx1<=m){
            arr[k++]=temp[idx1++];
        }
        
        while(idx2<=e){
            arr[k++]=temp[idx2++];
        }
    }
}