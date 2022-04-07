import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1249 {
	
	static class Point{
		int x, y, depth;
		public Point(int x, int y, int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	static int N, min;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map, resultMap;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			// 입력
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			// 시간 최솟값을 기록하는 map 
			resultMap = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(resultMap[i], Integer.MAX_VALUE);
			}
			resultMap[0][0] = 0;
			
			min = Integer.MAX_VALUE;
			
			bfs();
			
			System.out.println("#" + tc + " " + min);
		}
		
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			// 도착
			if(p.x == N-1 && p.y == N-1) {
				if(p.depth < min) min = p.depth;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					// 기존 시간보다 현재 경로의 시간이 더 빠를 경우
					if(p.depth + map[nx][ny] < resultMap[nx][ny]) {
						q.offer(new Point(nx, ny, p.depth + map[nx][ny]));
						resultMap[nx][ny] = p.depth + map[nx][ny];
					}
				}
			}
		}
	}
}
