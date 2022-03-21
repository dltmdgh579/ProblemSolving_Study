import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int N, L, R, count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());        
        L = Integer.parseInt(st.nextToken());        
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구 이동이 일어나지 않을 때까지 반복
        while(true){
            boolean isMove = false; // 인구이동 체크
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j)) isMove = true; // visited되지 않은 모든 위치 bfs
                    }
                }
            }
            if(!isMove) break;
            count++; // + 1일
        }
        System.out.println(count);

    }

    public static boolean bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;

        int sum = map[x][y];

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
                    if(diff >= L && diff <= R){
                        q.offer(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        // 연합이 이루어졌을 경우
        if(list.size() > 1){
            int avg = sum / list.size();
            for(Point p : list){
                map[p.x][p.y] = avg;
            }
            return true;
        }
        return false;
    }
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
