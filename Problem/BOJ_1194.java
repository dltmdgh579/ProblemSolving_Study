import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {

	static class Point{
		int x, y, keys, count;
		
		public Point(int x, int y, int keys, int count) {
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.count = count;
		}
	}
	
	static int N, M, startX, startY;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		// 입력
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs();
	}
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][1 << 6]; // 'a' ~ 'f' 키 소유
		visited[startX][startY][0] = true;
		
		q.add(new Point(startX, startY, 0, 0)); // 시작지점

		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				int key = p.keys; // 현재 p의 열쇠 건드리지 않음
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny][key]) {
					// 벽
					if(map[nx][ny] == '#') continue;

					// 출구
					else if(map[nx][ny] == '1') {
						System.out.println(p.count + 1);
						return;
					}
					
					// 열쇠
					else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
						key |= (1 << map[nx][ny] - 'a'); // 000000 중 획득 열쇠 값 1로 세팅
						visited[nx][ny][key] = true;
						q.add(new Point(nx, ny, key, p.count + 1));
					}
					
					// 문
					else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
						if(!((key & (1 << map[nx][ny] - 'A')) == 0)) { // 열쇠가 있을 경우
							visited[nx][ny][key] = true;
							q.add(new Point(nx, ny, key, p.count + 1));
						}
					}
					
					// 빈 칸
					else {
						visited[nx][ny][key] = true;
						q.add(new Point(nx, ny, key, p.count + 1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
