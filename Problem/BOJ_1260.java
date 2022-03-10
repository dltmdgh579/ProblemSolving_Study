import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static List<Integer>[] line;
    static int N, M, V;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[1001];

        line = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            line[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            line[u].add(v);
            line[v].add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(line[i]);
        }

        visited[V] = true;
        System.out.print(V + " ");
        dfs(V);

        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }
    public static void dfs(int now){
        for(int next : line[now]){
            if(!visited[next]){
                System.out.print(next + " ");
                visited[next] = true;
                dfs(next);
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");
            for(int next : line[current]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
