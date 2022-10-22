import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int N, M, robotX, robotY, robotD, count, check;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] backDx = {1, 0, -1, 0};
    static int[] backDy = {0, -1, 0, 1};
    static int[] dd = {3, -1, -1, -1};
    static int[][] map;
    static boolean flag;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        
        st = new StringTokenizer(br.readLine());
        robotX = Integer.parseInt(st.nextToken());
        robotY = Integer.parseInt(st.nextToken());
        robotD = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(count);

    }

    public static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(robotX, robotY, robotD));
        visited[robotX][robotY] = true;
        count++;

        while(!q.isEmpty()){
            Point p = q.poll();

            clean(q, p, p.d);
            if(flag) return;
        }

    }

    public static void clean(Queue<Point> q, Point p, int dir){
        if(check == 4){
            int nx = p.x + backDx[dir];
            int ny = p.y + backDy[dir];
            if(map[nx][ny] == 0){
                q.add(new Point(nx, ny, dir));
                check = 0;
            } else {
                flag = true;
            }
            return;
        }

        int nx = p.x + dx[dir];
        int ny = p.y + dy[dir];
        int nd = p.d + dd[dir]; 
        if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 1){
            q.add(new Point(nx, ny, nd));
            visited[nx][ny] = true;
            count++;
            check = 0;
        } else {
            q.add(new Point(p.x, p.y, nd));
            check++;
        }
    }

    static class Point{
        int x, y, d;
        public Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}