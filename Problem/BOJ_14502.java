import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

	static int N, M, max = Integer.MIN_VALUE;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wall(0);
		
		System.out.println(max);
	}

	public static void wall(int cnt) {
		// 벽 3개를 다 세웠을 경우
		if(cnt == 3) {
			// map 복사
			int[][] mapCopy = new int[N][M];
			copy(map, mapCopy);
			
			// 안전지역
			int safeArea = virus(mapCopy);
			max = Math.max(max, safeArea);
			return;
		}
		
		// 벽 세우기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static int virus(int[][] map) {
		// 초기 바이러스 큐에 저장
		virusInit();
		visited = new boolean[N][M];
		while(!q.isEmpty()) {
			int[] cur = q.poll();

			visited[cur[0]][cur[1]] = true;
			
			// 바이러스 확산
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					if(map[nx][ny] == 0) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						map[nx][ny] = 2;
					}
				}
			}
		}
		
		// 안전 영역 count 
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		return count;
	}
	
	public static void copy(int[][] map, int[][] mapCopy) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
	}
	
	public static void virusInit() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {					
					q.offer(new int[] {i, j});
				}
			}
		}
	}
}
