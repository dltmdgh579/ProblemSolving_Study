import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    // 위치 정보
    static class Point {
        int x, y, count;
        boolean crash; // 벽 부쉈는지 여부

        public Point(int x, int y, int count, boolean crash){
            this.x = x;
            this.y = y;
            this.count = count;
            this.crash = crash;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 벽을 부쉈을 경우, 부수지 않았을 경우 방문 체크

        // 입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        // 출력
        if(!bfs()) System.out.println(-1);
        
    }
    public static boolean bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1, false));

        while(!q.isEmpty()){
            Point current = q.poll();

            // N, M 위치에 도착한 첫번째 탐색 결과
            if(current.x == N-1 && current.y == M-1){
                System.out.println(current.count);
                return true;
            }

            // 4방탐색
            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 1. 범위 내
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    // 2. 벽이 아닐 경우
                    if(map[nx][ny] == '0'){
                        // 2-1. 벽을 부수지 않았을 경우
                        if(!current.crash && !visited[nx][ny][0]){
                            q.offer(new Point(nx, ny, current.count+1, false));
                            visited[nx][ny][0] = true;
                        } 
                        // 2-2. 벽을 부쉈을 경우
                        else if(current.crash && !visited[nx][ny][1]){
                            q.offer(new Point(nx, ny, current.count+1, true));
                            visited[nx][ny][1] = true;
                        }
                    } 
                    // 3. 벽일 경우
                    else if(map[nx][ny] == '1'){
                        // 3-1. 벽을 부수지 않았을 경우
                        if(!current.crash){
                            q.offer(new Point(nx, ny, current.count+1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
