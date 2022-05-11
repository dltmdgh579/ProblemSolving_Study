import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167 {

    // 간선 정보
    static class Node{
        int to, weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int max, node;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];

        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for(int i=0; i<V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                list[from].add(new Node(to, weight));
            }
        }
        // 임의의 노드에서 가장 먼 노드 탐색
        visited = new boolean[V+1];
        dfs(1, 0);

        // 탐색한 노드에서 가장 먼 노드 탐색
        visited = new boolean[V+1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int w){
        if(w > max){
            max = w;
            node = x;
        }
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            Node n = list[x].get(i);
            if(!visited[n.to]){
                dfs(n.to, w + n.weight);
            }
        }
    }
}
