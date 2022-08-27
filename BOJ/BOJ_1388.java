import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {

    static int N, M, ans;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        ans = 0;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]) continue;
                ans++;
                dfs(i, j);
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;

        int dir = map[i][j] == '-' ? 0 : 1;  
        int nx = i + dx[dir];
        int ny = j + dy[dir];

        if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == map[i][j]){
            dfs(nx, ny);
        }
    }
}
