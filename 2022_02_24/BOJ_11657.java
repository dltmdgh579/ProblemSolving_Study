import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11657 {

    // 도시 정보
    static class Node {
        int from, to, weight;

        public Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M, INF = 10000000;
    static ArrayList<Node> node;
    static long[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선 개수

        node = new ArrayList<>(); // 노선 정보
        dist = new long[N+1]; // 해당 노드 시간값

        // 모든 노드 Infinity값으로 초기화
        for(int i=1; i<=N; i++){
            dist[i] = INF;
        }

        // 노선 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            node.add(new Node(A, B, C));
        }

        if(bellmanFord()){
            // 1번 도시에서 다른 도시로 가는 시간이므로 i는 2부터 시작
            for(int i=2; i<=N; i++){
                if(dist[i] == INF) System.out.println(-1); // 갈 수 없는 경로
                else System.out.println(dist[i]);
            }
        }
    }

    // 벨만 포드
    public static boolean bellmanFord(){
        dist[1] = 0;

        // N-1번 반복
        for(int i=0; i<N-1; i++){
            // 전체 간선 확인
            for(int j=0; j<M; j++){
                if(dist[node.get(j).from] == INF){
                    continue;
                }
                // to로 가는 최단거리보다 from에서 가중치를 더해 가는 거리가 더 짧을 경우 갱신
                if(dist[node.get(j).to] > dist[node.get(j).from] + node.get(j).weight){
                    dist[node.get(j).to] = dist[node.get(j).from] + node.get(j).weight;
                }
            }
        }

        // 한번 더 반복하여 음의 사이클 체크
        for(int i=0; i<M; i++){
            if(dist[node.get(i).from] != INF && dist[node.get(i).to] > dist[node.get(i).from] + node.get(i).weight){
                System.out.println(-1);
                return false;
            }
        }
        return true;
    }
}
