import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static ArrayList<Integer>[] list;
    static int V, E;
    static int[] point;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for(int tc=0; tc<K; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            point = new int[V + 1];

            for(int i=0; i<=V; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            boolean flag = false;
            for(int i=1; i<=V; i++){
                if(point[i] == 0){
                    point[i] = 1;
                    flag = bfs(i);
                }
                if(!flag) break;
            }

            if(!flag) System.out.println("NO");
            else System.out.println("YES");
        }
        
    }

    public static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list[cur]){
                if(point[next] == 0){
                    q.add(next);
                }

                if(point[next] == point[cur]){
                    return false;
                }

                if(point[next] == 0 && point[cur] == 1){
                    point[next] = 2;
                } else if(point[next] == 0 && point[cur] == 2){
                    point[next] = 1;
                }
            }
        }
        return true;
    }
}
