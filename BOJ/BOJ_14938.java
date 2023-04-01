import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938 {
    
    static class Node implements Comparable<Node>{
        int to, weight;
        
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }
    
    static int n, m, r, max;
    static int[] items, dist;
    static boolean[] check;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to, weight));
            list.get(to).add(new Node(from, weight));
        }

        dist = new int[n+1];
        check = new boolean[n+1];

        for(int i=1; i<=n; i++){
            max = Math.max(max, dijkstra(i));
        }

        System.out.println(max);
    }

    public static int dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(!check[cur.to]){
                check[cur.to] = true;

                for(Node node : list.get(cur.to)){
                    if(!check[node.to] && dist[node.to] > dist[cur.to] + node.weight){
                        dist[node.to] = dist[cur.to] + node.weight;
                        pq.add(new Node(node.to, dist[node.to]));
                    }
                }
            }
        }
        int sum = 0;

        for(int i=1; i<=n; i++){
            if(dist[i] <= m){
                sum += items[i];
            }
        }

        return sum;
    }
}
