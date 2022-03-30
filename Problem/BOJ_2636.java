import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

	static int R, C, cnt, cheese;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];

		// 입력
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		int cheeseCnt = 0;
		// 치즈가 모두 없어질 때까지 한 시간 단위로 반복
		while(cheese != 0) {
			cheeseCnt = cheese;
			bfs();
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(cheeseCnt);
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		
		visited = new boolean[R][C];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
					// 치즈를 만날 경우
					if(map[nx][ny] == 1) {
						map[nx][ny] = 0;
						cheese--;
					}
					// 공기
					else if(map[nx][ny] == 0) {
						q.offer(new int[] {nx, ny});
					}
					visited[nx][ny] = true;
				}
			}
		}
	}

}
