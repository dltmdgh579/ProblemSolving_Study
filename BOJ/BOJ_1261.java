import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {

    static int N, M, min = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(min);

    }
    public static void bfs(){
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(0, 0, 0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == N-1 && p.y == M-1){
                min = Math.min(p.breakCount, min);
                break;
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        q.offer(new Point(nx, ny, p.breakCount + 1));
                    } else {
                        q.offer(new Point(nx, ny, p.breakCount));
                    }
                    visited[nx][ny] = true;
                }
            }
        }

    }

    static class Point implements Comparable<Point>{
        int x, y, breakCount;
        public Point(int x, int y, int breakCount){
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
        }
        @Override
        public int compareTo(Point o) {
            return this.breakCount - o.breakCount;
        }
    }
}