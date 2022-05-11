import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    // 간선 정보
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int N, M, X, INF = 10000000;
    static ArrayList<ArrayList<Node>> list, listReverse;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(); // 본래 간선 리스트
        listReverse = new ArrayList<>(); // 간선을 반대로 입력받은 리스트
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
            listReverse.add(new ArrayList<>());
        }

        // 간선 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            listReverse.get(end).add(new Node(start, weight));
        }

        // 최단거리 배열
        int[] dist1 = dijkstra(list); // X에서 돌아오는 최단거리
        int[] dist2 = dijkstra(listReverse); // 각 지점에서 X로 가는 최단거리

        int result = 0;
        for(int i=1; i<=N; i++){
            result = Math.max(result, dist1[i] + dist2[i]);
        }
        System.out.println(result);
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> alist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, INF);
        dist[X] = 0;

        while(!pq.isEmpty()){
            int cur = pq.poll().end;
            if(!visited[cur]){
                visited[cur] = true;

                for(Node n : alist.get(cur)){
                    if(dist[n.end] > dist[cur] + n.weight){
                        dist[n.end] = dist[cur] + n.weight;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist;
    }
}
