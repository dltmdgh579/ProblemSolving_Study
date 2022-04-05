import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656 {

	static class Point{
		int x, y, num;
		public Point(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static int N, W, H, minBrick;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			// 입력
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minBrick = Integer.MAX_VALUE;
			shoot(0, map);
			System.out.println("#" + tc + " " +  minBrick);
		}
		
	}
	
	public static void shoot(int cnt, int[][] map) {
		// 구슬을 모두 던진 경우
		if(cnt == N) {
			int brickCnt = brickCount(map);
			if(brickCnt < minBrick) minBrick = brickCnt;
			return;
		}
		
		int[][] mapCopy = new int[H][W];
		for(int i=0; i<W; i++) {
			copy(map, mapCopy); // 배열 상태 백업
			breaking(i, mapCopy); // 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리
			mapSort(mapCopy); // 부서진 벽돌 정리
			shoot(cnt+1, mapCopy); // 다음 구슬 던지기
		
		}
	}
	
	public static void breaking(int col, int[][] map) {
		for(int i=0; i<H; i++) { // 구슬이 벽돌에 맞을 때 까지
			if(map[i][col] >= 1) { // 벽돌에 맞았을 경우
				// 벽돌크기 1인 경우
				if(map[i][col] == 1) {
					map[i][col] = 0;
					return;
					
				// 벽돌크기 2이상인 경우
				} else {
					// bfs
					Queue<Point> q = new LinkedList<>();
					q.offer(new Point(i, col, map[i][col]));
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						map[p.x][p.y] = 0;
						for(int dir=0; dir<4; dir++) {
							int numCnt = p.num;
							int nx = p.x;
							int ny = p.y;
							
							// 벽돌크기 -1만큼 반복
							while(--numCnt > 0) {
								nx += dx[dir];
								ny += dy[dir];
								if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
									// 부수게 될 벽돌크기가 2이상인 경우 큐에 저장
									if(map[nx][ny] > 1) {
										q.offer(new Point(nx, ny, map[nx][ny]));
									}
									map[nx][ny] = 0;
								}
								else break;
							}
						}
					}
					return;
				}
			}
		}
	}
	
	// 벽돌 개수 count
	public static int brickCount(int[][] map) {
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 0) count++;
			}
		}
		return count;
	}
	
	public static void mapSort(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r = H-1;// 아래행 시작
			while(r>0) {
				if(map[r][c]==0) { // 빈칸이면 내릴 벽돌 찾기
					int nr = r-1;
					while(nr>0 && map[nr][c]==0) nr--;
					
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				r--;
			}
		}
	}
	
	public static void copy(int[][] map, int[][] mapCopy) {
		for(int r = 0; r<H; r++) {
			for(int c=0; c<W; c++) {
				mapCopy[r][c] = map[r][c];
			}
		}
	}
	
}
