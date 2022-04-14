import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

    static int M, N, K;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean flag;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            // 입력
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                map[X][Y] = 1;
            }

            int count = 0;
            // 배추가 있는 곳 모두 탐색
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 1){
                        bfs(i, j);
                        if(flag) count++;
                        flag = false;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void bfs(int sr, int sc){
        Queue<int[]> q = new LinkedList<>();
        // 방문처리가 되지 않은 곳이면 탐색 시작
        if(!visited[sr][sc]){
            q.offer(new int[] {sr, sc});
            flag = true; // 배추흰지렁이 필요
        }
        visited[sr][sc] = true; 
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        q.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    
}
