import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865{
    static class Node{
        int end, time;
        public Node(int end, int time){
            this.end = end;
            this.time = time;
        }
    }

    static int N, M, W, INF=10000000;
    static int[] dist;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int t=0; t<TC; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N+1];
            list = new ArrayList<>();
            for(int i=0; i<=N; i++){
                list.add(new ArrayList<>());
            }

            for(int i=0; i<M+W; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                //웜홀 -> 단방향
                if(i >= M) {
                    list.get(start).add(new Node(end, -time));
                    continue;
                }
                list.get(start).add(new Node(end, time));
                list.get(end).add(new Node(start, time));
            }

            boolean MinusCycle = false; //음의 사이클 체크
            // 모든 지점을 시작점으로 탐색
            for(int i=1; i<=N; i++){
                if(bellmanFord(i)){
                    MinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if(!MinusCycle){
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());


    }
    public static boolean bellmanFord(int start){
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        // 정점의 개수 - 1 만큼 반복
        for(int i=1; i<N; i++){
            update = false;

            // 최단거리 갱신
            for(int j=1; j<=N; j++){
                for(Node n : list.get(j)){
                    if(dist[j] != INF && dist[n.end] > dist[j] + n.time){
                        dist[n.end] = dist[j] + n.time;
                        update = true;
                    }
                }
            }

            // 최단거리가 더이상 갱신되지 않을 경우 break
            if(!update){
                break;
            }
        }

        // 정점의 개수 -1 만큼 업데이트 반복 후 업데이트가 발생하면 음의 사이클
        if(update){
            for(int i=1; i<=N; i++){
                for(Node n : list.get(i)){
                    if(dist[i] != INF && dist[n.end] > dist[i] + n.time){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}