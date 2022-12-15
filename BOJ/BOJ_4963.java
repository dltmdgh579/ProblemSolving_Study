import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int w, h;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
    
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        bfs(i, j);
                        count++;
                    }
                }
            }
    
            System.out.println(count);
        }
    }

    public static boolean bfs(int startX, int startY){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visited[startX][startY] = true;
        boolean flag = false;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int d=0; d<8; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] == 1){
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    flag = true;
                }
            }
        }
        return flag;
    }

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}