import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2665 {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dist;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        map = new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j)-'0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(dist[n-1][n-1]);
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        dist[0][0] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] > dist[cur.x][cur.y]){
                    if(map[nx][ny] == 1){
                        dist[nx][ny] = dist[cur.x][cur.y];
                    } else {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    }
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
