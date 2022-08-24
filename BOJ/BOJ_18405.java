import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18405 {

    static int N, K, S, X, Y;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        loop: for(int n=0; n<S; n++){
            for(int i=1; i<K+1; i++){
                spread(i);
                if(map[X][Y] != 0) break loop;
            }
        }

        System.out.println(map[X][Y]);
    }
    public static void spread(int virusNum){
        Queue<Point> q = new LinkedList<>();

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(map[i][j] == virusNum){
                    q.add(new Point(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int k=0; k<4; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx >= 1 && nx < N+1 && ny >= 1 && ny < N+1){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = virusNum;
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