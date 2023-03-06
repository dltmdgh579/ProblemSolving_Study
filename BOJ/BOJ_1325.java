import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
    static ArrayList<ArrayList<Integer>> list;
    static int count, max;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        visited = new boolean[N+1];

        list = new ArrayList<>();

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(B).add(A);
        }

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(max, count);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(result[i] == max){
                sb.append(i + " ");
            }
        }
        
        System.out.println(sb.toString());
    }

    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list.get(cur)){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

    }
}
