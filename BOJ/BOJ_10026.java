import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

    // 위치 정보
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, normal, weekness;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board, cboard;
    static boolean[][] visited, cvisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];
        cboard = new char[N][N]; //적록색약
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                board[i][j] = c;
                if(c == 'G'){
                    cboard[i][j] = 'R';
                } else {
                    cboard[i][j] = c;
                }
            }
        }

        visited = new boolean[N][N];
        cvisited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 정상 구역 탐색
                if(!visited[i][j]){
                    normal++;
                    visited[i][j] = true;
                    bfs(i, j, board, visited);
                }
                // 적록색약 구역 탐색
                if(!cvisited[i][j]){
                    weekness++;
                    cvisited[i][j] = true;
                    bfs(i, j, cboard, cvisited);
                }
            }
        }
        System.out.println(normal + " " + weekness);
    }

    public static void bfs(int x, int y, char[][] board, boolean[][] visited){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        char curColor = board[x][y];

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    if(board[nx][ny] == curColor){
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
