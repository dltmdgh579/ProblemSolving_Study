import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static int n, m, count, area, maxArea;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        System.out.println(count + "\n" + maxArea);
	}

    public static void bfs(int i, int j){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        visited[i][j] = true;
        count++;

        while(!q.isEmpty()){
            Node node = q.poll();
            area++;

            for(int d=0; d<4; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        maxArea = Math.max(maxArea, area);
        area = 0;
    }
    
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}