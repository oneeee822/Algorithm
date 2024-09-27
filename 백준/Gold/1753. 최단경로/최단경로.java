import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dijkstraT;

    static class Node {
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w)); // 최단 거리로 갱신
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (i == K) {
                sb.append(0).append("\n");
            } else if (dijkstraT[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dijkstraT[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int s) {
        visited = new boolean[V + 1];
        dijkstraT = new int[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        Arrays.fill(dijkstraT, Integer.MAX_VALUE);
        dijkstraT[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.n]) continue;
            visited[cur.n] = true;

            for (Node node : graph[cur.n]) {
                if (visited[node.n]) continue;
                int newW = cur.cost + node.cost;
                int originW = dijkstraT[node.n];
                if (originW > newW) {
                    dijkstraT[node.n] = newW;
                    pq.add(new Node(node.n, newW));
                }
            }
        }
    }
}
