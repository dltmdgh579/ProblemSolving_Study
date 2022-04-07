import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953 {

	static class Point{
		int x, y, time;
		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int N, M, R, C, L, cnt;
	// 상, 좌, 하, 우
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// 터널 구조물
	public static int[][] dir = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 0}};
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			// 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.offer(new Point(R, C, 1));
		visited[R][C] = true;
		
		cnt = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			cnt++;
			
			// 현재 도둑 p 소요 시간 경과
			if(p.time == L) {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				// 터널 구조물 확인
				if(dir[map[p.x][p.y]][i] == 0) continue;
				
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						
						// 현재 : 상으로 진행 -> next : 터널 구조물에 하 방향이 있어야 함
						if(dir[map[nx][ny]][(i+2)%4] != 0) {
							q.offer(new Point(nx, ny, p.time + 1));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
	}
}
