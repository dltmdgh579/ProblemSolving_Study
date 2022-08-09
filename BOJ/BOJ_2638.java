import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2638 {

    static int N, M, total, time;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) total++;
            }
        }

        while(total != 0){
            time++;
            check();
            bfs();
        }
        System.out.println(time);
    }

    public static void check(){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new Point(0, 0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            map[p.x][p.y] = 2;          
            
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                    if(map[nx][ny] == 0 || map[nx][ny] == 2){
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void bfs(){
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1){
                    int meltingCount = 0;
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 2 && !visited[nx][ny]){
                            meltingCount++;
                        }
                        if (meltingCount == 2) {
                            total--;
                            visited[i][j] = true;
                            map[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}