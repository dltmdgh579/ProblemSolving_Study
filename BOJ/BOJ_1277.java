import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1277 {
    static int N, W;
    static double M;
    static double[] distArr;
    static boolean[][] check;
    static Point[] point;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine());

        point = new Point[N+1];
        check = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[i] = new Point(x, y);
        }

        for(int i=0; i<W; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            check[from][to] = true;
            check[to][from] = true;
        }

        dijkstra();
        System.out.println((int)(distArr[N] * 1000));
    }

    public static void dijkstra(){
        distArr = new double[N+1];
        Arrays.fill(distArr, 200001);
        distArr[1] = 0;

        for(int i=2; i<=N; i++){
            if(check[1][i]) distArr[i] = 0;
        }
        
        boolean[] visited = new boolean[N + 1];
        for(int i=1; i<=N; i++){
            double minDist = 200001;
            int cur = 0;
            for(int j=1; j<=N; j++){
                if(!visited[j] && minDist >= distArr[j]){
                    minDist = distArr[j];
                    cur = j;
                }
            }

            if(cur == N) break;
            visited[cur] = true;

            for(int j=1; j<=N; j++){
                if(j == cur) continue;
                double dist = 0;
                if(check[cur][j]) {
                    dist = 0;
                } else {
                    dist = Math.sqrt(Math.pow(point[cur].x - point[j].x, 2) + Math.pow(point[cur].y - point[j].y, 2));
                }

                if(dist > M) continue;
                if(distArr[j] > distArr[cur] + dist){
                    distArr[j] = distArr[cur] + dist;
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
