import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17484 {
    static int N, M, min = Integer.MAX_VALUE;
    static int[] dc = {-1, 0, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            dfs(0, i, -2, map[0][i]);
        }

        System.out.println(min);
        
    }

    public static void dfs(int r, int c, int dir, int sum){
        if(r == N-1) {
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<3; i++){
            if(i == dir) continue;
            int nr = r + 1;
            int nc = c + dc[i];

            if(nr < N && nc >= 0 && nc < M){
                dfs(nr, nc, i, sum + map[nr][nc]);
            }
        }

    }
}
