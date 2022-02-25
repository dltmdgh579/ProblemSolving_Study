import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22865 {
    // 거리 정보
    static class Edge implements Comparable<Edge>{
        int to, weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int N, A, B, C;
    static List<Edge>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 땅 후보 개수
        
        list = new ArrayList[N+1]; // 인접리스트

        // 인접리스트 초기화
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<Edge>();
        }

        // 세 명의 친구들이 살고 있는 집 입력
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); // 간선 개수

        // 모든 간선 양방향 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list[D].add(new Edge(E, W));
            list[E].add(new Edge(D, W));
        }

        // 각 친구들 집에서 다른 모든 집의 최단거리 배열
        int[] dA = dijkstra(A);
        int[] dB = dijkstra(B);
        int[] dC = dijkstra(C);

        int max = -1;
        int maxIdx = -1;

        // 친구들 집으로 부터 가장 먼 곳 조사
        for(int i=1; i<=N; i++){
            int a = dA[i];
            int b = dB[i];
            int c = dC[i];

            // i번째 땅과 친구들 집의 거리 중 최소
            int min = Math.min(a, b);
            min = Math.min(min, c);

            // i번째 집의 최소 거리가 max보다 클 경우 갱신
            if(min > max){
                max = min;
                maxIdx = i;
            } 
            // 최소 거리가 max와 같을 경우 더 작은 번호로 갱신
            else if(max == min && maxIdx > i){
                maxIdx = i;
            }
        }
        // 땅 번호 출력
        System.out.println(maxIdx);
    }

    public static int[] dijkstra(int start){
        // 거리 배열 초기화
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0; // 시작점 0

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0)); // 시작점부터 출발

        // 현재 정점의 모든 간선 정보 업데이트
        while(!pq.isEmpty()){
            Edge current = pq.poll(); // 현재 정점

            if(current.weight > distance[current.to]) continue; // 최단 거리보다 현재 값이 높을 경우 continue

            // 현재 정점에 연결된 간선 정보 업데이트
            int len = list[current.to].size();
            for(int i=0; i<len; i++){
                Edge e = list[current.to].get(i); // 현재 정점에 연결된 간선

                // to로 가는 최단 거리보다 현재 정점을 경유하여 to로 가는 경우가 더 짧을 경우 갱신
                if(distance[e.to] > current.weight + e.weight){
                    distance[e.to] = current.weight + e.weight;

                    // 최단거리가 갱신되었으므로 해당 지점을 다시 탐색하기 위해 큐에 저장
                    pq.offer(new Edge(e.to, distance[e.to]));
                }
            }
        }
        return distance;
    }
}
