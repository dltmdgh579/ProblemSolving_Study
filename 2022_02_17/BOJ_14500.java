import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 나머지 도형(상하좌우)
    static int[][] other_x = {{0, 0, -1}, {0, 0, 1}, {1, 2, 1}, {1, 2, 1}};
    static int[][] other_y = {{1, 2, 1}, {1, 2, 1}, {0, 0, -1}, {0, 0, 1}};
    static int[][] arr;
    static boolean[][] check;
    static int N, M, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M];

        // 배열 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열의 모든 지점에서 각각 모든 도형 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                check[i][j] = true; // 현재 지점 방문
                int len = 1;
                int sum = 0;

                sum += arr[i][j];

                dfs(i, j, len, sum); // 현재 지점으로부터 dfs
                check[i][j] = false; // dfs 후 현재 지점 방문 해제

                other(i, j, sum); // ㅜ 모양 탐색
            }
        }
        System.out.println(max);
    }

    // ㅜ 제외 모든 도형 탐색
    public static void dfs(int n, int m, int len, int sum){
        // 길이가 4이면 max값 비교 후 종료
        if(len == 4){
            max = Math.max(sum, max);
            return;
        }

        // 4방탐색
        for(int i=0; i<4; i++){
            int nx = n + dx[i];
            int ny = m + dy[i];

            // 배열 범위 안에 있을 경우
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                if(!check[nx][ny]){
                    check[nx][ny] = true; // 방문

                    dfs(nx, ny, len + 1, sum + arr[nx][ny]); // 현재 지점으로 부터 dfs
                    check[nx][ny] = false; // 방문 해제
                }
            }
        }
    }

    // ㅜ 도형 탐색
    public static void other(int n, int m, int sum){
        // 4가지 모양
        for(int i=0; i<4; i++){
            int temp = sum; // sum값 저장

            // 4가지 모양 중 하나 탐색
            for(int j=0; j<3; j++){
                int nx = n + other_x[i][j];
                int ny = m + other_y[i][j];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    sum += arr[nx][ny];
                }
                else break;
            }
            max = Math.max(sum, max); // 모양 하나 완성 후 max 값 비교
            sum = temp; // sum 값 초기화
        }
    }
}
