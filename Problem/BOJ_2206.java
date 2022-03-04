import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static class Point {
        int x, y, count;
        boolean crash;

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
        visited = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        if(!bfs()) System.out.println(-1);
        
    }
    public static boolean bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1, false));

        while(!q.isEmpty()){
            Point current = q.poll();

            if(current.x == N-1 && current.y == M-1){
                System.out.println(current.count);
                return true;
            }

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(map[nx][ny] == '0'){
                        if(!current.crash && !visited[nx][ny][0]){
                            q.offer(new Point(nx, ny, current.count+1, false));
                            visited[nx][ny][0] = true;
                        } else if(current.crash && !visited[nx][ny][1]){
                            q.offer(new Point(nx, ny, current.count+1, true));
                            visited[nx][ny][1] = true;
                        }
                    } else if(map[nx][ny] == '1'){
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
