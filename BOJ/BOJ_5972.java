import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {

    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        visited[1] = true;
        dist[1] = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();

            for(Node node : list.get(n.end)){
                if(dist[node.end] > dist[n.end] + node.cost){
                    dist[node.end] = dist[n.end] + node.cost;
                    pq.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int end, cost;
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }        
    }
}