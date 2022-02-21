import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
    static int N, min;
    static int[][] W;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        check = new boolean[N];

        // 비용 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        // 첫 번째 도시부터 마지막 도시 출발 순서로 dfs
        for(int i=0; i<N; i++){
            check[i] = true;
            dfs(i, i, 0, 0);
            check[i] = false;
        }

        System.out.println(min);
    }
    
    public static void dfs(int start, int now, int sum, int cnt){
        
        // N-1번 여행 후에는 출발 도시로 돌아오는 경로로 계산
        if(cnt == N-1){
            if(W[now][start] != 0){
                sum += W[now][start];
                if(sum < min) min = sum;
            }
            return;
        }

        // 여행 경로
        for(int i=0; i<N; i++){
            if(!check[i] && W[now][i] != 0){ // 방문하지 않은 곳, 갈 수 있는 경로
                check[i] = true; // 방문
                dfs(start, i, sum + W[now][i], cnt+1);
                check[i] = false; // 방문 해제
            }
        }
    }
}
