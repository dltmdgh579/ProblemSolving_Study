import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int N, count;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int dir){
        if(r == N && c == N){
            count++;
            return;
        }

        switch(dir) {
        //가로 -> 가로
        case 0:
            if(c + 1 <= N && map[r][c + 1] == 0){
                dfs(r, c + 1, 0);
            }
            break;
        //세로 -> 세로
        case 1:
            if(r + 1 <= N && map[r + 1][c] == 0){
                dfs(r + 1, c, 1);
            }
            break;
        //대각선 -> 가로, 세로
        case 2:
            if(c + 1 <= N && map[r][c + 1] == 0){
                dfs(r, c + 1, 0);
            }
            if(r + 1 <= N && map[r + 1][c] == 0){
                dfs(r + 1, c, 1);
            }
            break;
        }

        //->대각선
        if(r + 1 <= N && c + 1 <= N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0){
            dfs(r + 1, c + 1, 2);
        }
    }
}
