import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static class Point{
        int x, y, cnt;

        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int l, knightX, knightY, goalX, goalY;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] board;
    static boolean[][] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            l = Integer.parseInt(br.readLine());

            board = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            knightX = Integer.parseInt(st.nextToken());
            knightY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            board[goalX][goalY] = -1;

            bfs();

        }
    }

    public static void bfs(){
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(knightX, knightY, 0));
        visited[knightX][knightY] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();

            if(board[p.x][p.y] == -1){
                System.out.println(p.cnt);
                return;
            }

            for(int i=0; i<8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx < l && ny >= 0 && ny < l){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, p.cnt + 1));
                    }
                }
            }
        }
    }
}
