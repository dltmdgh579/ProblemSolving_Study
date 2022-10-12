import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
 
    static int F, S, G, U, D;
    static int[] visited;
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

        visited = new int[F+1];

        bfs();
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(G == cur){
                System.out.println(visited[cur] - 1);
                return;
            }
            
            if(F >= cur + U){
                if(visited[cur + U] == 0){
                    q.add(cur + U);
                    visited[cur + U] = visited[cur] + 1;
                }
            }
            
            if(1 <= cur - D){
                if(visited[cur - D] == 0){
                    q.add(cur - D);
                    visited[cur - D] = visited[cur] + 1;
                }
            }
        }
        System.out.println("use the stairs");
        return;
    }
}