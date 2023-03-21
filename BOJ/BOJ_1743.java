import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static int N, M, K, count, max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        checked = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 2;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(checked[i][j] || map[i][j] != 2) continue;
                count = 1;
                dfs(i, j);
                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int r, int c){

        checked[r][c] = true;

        for(int d=0; d<4; d++){
            int nr = r + dx[d];
            int nc = c + dy[d];

            if(nr >= 1 && nr <= N && nc >= 1 && nc <= M){
                if(checked[nr][nc] || map[nr][nc] != 2) continue;
                dfs(nr, nc);
                count++;
            }
        }
        
    }
}
