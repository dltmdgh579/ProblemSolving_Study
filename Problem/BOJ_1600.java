import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	static int K, W, H;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] hdx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hdy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[][] map;
	static boolean[][][] visited;

	// 원숭이 정보
	static class Point{
		int x, y, count, horseCount;
		public Point(int x, int y, int count, int horseCount) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.horseCount = horseCount;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		// 입력
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0, K)); // 시작지점
		
		visited = new boolean[H][W][K+1]; // 말의 움직임 횟수에 따라 방문지점 분리
		visited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Point monkey = q.poll();
			
			// 도착지점
			if(monkey.x == H-1 && monkey.y == W-1) {
				System.out.println(monkey.count);
				return;
			}
			
			// 인접한 네 방향으로 한 번 움직이는 경우
			for(int i=0; i<4; i++) {
				int nx = monkey.x + dx[i];
				int ny = monkey.y + dy[i];
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][monkey.horseCount]) {
					if(map[nx][ny] == 0) {
						q.offer(new Point(nx, ny, monkey.count+1, monkey.horseCount));
						visited[nx][ny][monkey.horseCount] = true;
					}
				}
			}
			
			// 말의 움직임으로 한 번 움직이는 경우
			if(monkey.horseCount > 0) {	
				for(int i=0; i<8; i++) {
					int nx = monkey.x + hdx[i];
					int ny = monkey.y + hdy[i];
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][monkey.horseCount-1]) {
						if(map[nx][ny] == 0) {
								q.offer(new Point(nx, ny, monkey.count+1, monkey.horseCount-1));
								visited[nx][ny][monkey.horseCount-1] = true;
							}
						}
					}
				}
			}
		System.out.println(-1);
	}
}
