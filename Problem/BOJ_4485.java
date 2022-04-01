import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {

	static class Point implements Comparable<Point>{
		int x, y, cost;
		
		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, tc;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int map[][], costMap[][];
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			// N의 입력이 0일때까지 반복
			if(N == 0) break;
			
			map = new int[N][N];
			costMap = new int[N][N];
			
			// 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					costMap[i][j] = Integer.MAX_VALUE; // cost값 무한대로 초기화
				}
			}
			
			System.out.println("Problem " + ++tc + ": " + dijkstra());
		}
	}
	public static int dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.offer(new Point(0, 0, map[0][0])); // 시작지점
		
		costMap[0][0] = map[0][0]; // 초기 값
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					// 현재 지점을 경유하는 비용이 더 작을 경우
					if(costMap[nx][ny] > costMap[p.x][p.y] + map[nx][ny]) {
						costMap[nx][ny] = costMap[p.x][p.y] + map[nx][ny];
						pq.offer(new Point(nx, ny, costMap[nx][ny]));
					}
				}
			}
		}
		return costMap[N-1][N-1];
	}
}
