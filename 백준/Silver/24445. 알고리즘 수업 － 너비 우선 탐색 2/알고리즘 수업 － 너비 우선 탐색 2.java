import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int n,m,r;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		list=new ArrayList[n+1];
		for(int i=1;i<=n;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i=1;i<=n;i++) Collections.sort(list[i], Collections.reverseOrder());
		bfs(r);
	}

	private static void bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		boolean []visited=new boolean[n+1];
		visited[x]=true;
		
		int cnt=0;
		int []order=new int[n+1];
		while(!queue.isEmpty()) {
			int q=queue.poll();
			cnt++;
			order[q]=cnt;
			
			for(int i:list[q]) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
		
		for(int i=1;i<=n;i++) System.out.println(order[i]);
	}
	
}