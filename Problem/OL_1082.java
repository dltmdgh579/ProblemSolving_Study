import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OL_1082 {
	
	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] visited, fvisited;
	
	// 용사 위치
	static class Point{
		int x, y, count;
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		int pointX = 0;
		int pointY = 0;
		
		// 입력
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') { // 용사위치
					pointX = i;
					pointY = j;
				}
			}
		}
		
		bfs(pointX, pointY);
	}
	
	public static void bfs(int pointX, int pointY) {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[R][C];
		
		q.offer(new Point(pointX, pointY, 0));
		visited[pointX][pointY] = true;
		int turn = -1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			// 불 옮기기
			if(turn != p.count) { // 같은 시간에 다른 경우의 움직이는 용사가 있으면 불 옮기지 않음.				
				fvisited = new boolean[R][C];
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] == '*' && !fvisited[i][j]) {
							fvisited[i][j] = true;
							for(int k=0; k<4; k++) {
								int nx = i + dx[k];
								int ny = j + dy[k];
								if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
									if(map[nx][ny] != 'D' && map[nx][ny] != 'X' && map[nx][ny] != '*') {
										fvisited[nx][ny] = true;
										map[nx][ny] = '*';
									}
								}
							}
						}
					}
				}
				turn = p.count;
			}
			// 용사 이동
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(map[nx][ny] == 'D') {
						System.out.println(p.count + 1);
						return;
					}
					if(map[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = 'S';
						q.offer(new Point(nx, ny, p.count + 1));
					}
				}
			}
		}
		System.out.println("impossible");
		return;
	}

}
