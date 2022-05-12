import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    //간선정보
    static class Node implements Comparable<Node>{
        int end, weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    // INF = 최대 간선 개수 200,000 * 최대 거리 1000
    static int N, E, INF = 200000001;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];

        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        // 경유지
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // v1을 먼저 경유할 경우
        int move1 = 0;
        move1 += dijkstra(1, v1);
        move1 += dijkstra(v1, v2);
        move1 += dijkstra(v2, N);
        
        // v2를 먼저 경유할 경우
        int move2 = 0;
        move2 += dijkstra(1, v2);
        move2 += dijkstra(v2, v1);
        move2 += dijkstra(v1, N);
        
        System.out.println((move1>=INF && move2>=INF) ? -1 : Math.min(move1, move2));
    }

    public static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        pq.offer(new Node(start, 0));

        dist[start] = 0;

        while(!pq.isEmpty()){
            int cur = pq.poll().end;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node n : list.get(cur)){
                    if(!visited[n.end] && dist[n.end] > dist[cur] + n.weight){
                        dist[n.end] = dist[cur] + n.weight;
                        pq.offer(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
