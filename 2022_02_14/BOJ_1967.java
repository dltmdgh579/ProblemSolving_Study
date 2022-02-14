import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {
    // 간선 정보 저장
    static class Node{
        int node, dist;
        public Node(int node, int dist){
            this.node = node; // 노드 번호
            this.dist = dist; // 가중치
        }
    }

    static ArrayList<Node>[] list;
    static boolean[] visit;
    static int max = 0;
    static int max_idx = 0;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 노드 연결 정보 저장하는 배열
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

             // 부모 자식 간선 정보 저장
            list[p].add(new Node(c, w));
            list[c].add(new Node(p, w));
        }

        // dfs 할 때 방문 여부 저장
        visit = new boolean[N+1];
        visit[1] = true;
        // 루트 노드(1) 기준으로 가장 가중치가 큰 노드 탐색
        dfs(1, 0);

        visit = new boolean[N+1];
        visit[max_idx] = true;
        // 가장 가중치가 큰 노드 기준으로 다시 탐색
        dfs(max_idx, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int dist){
        // 가중치 max 값, 노드 번호 갱신
        if(dist > max){
            max = dist;
            max_idx = idx;
        }

        // 노드에 연결된 모든 노드 탐색
        for(Node n : list[idx]){
            if(!visit[n.node]){ // 방문하지 않은 곳일 경우 진행
                visit[n.node] = true;
                dfs(n.node, dist + n.dist);
            }
        }
    }
}
