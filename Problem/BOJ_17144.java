package _0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {
	
	// 확산되는 미세먼지 정보
	static class Dust {
		int x, y, w;
		
		public Dust(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		int T = Integer.parseInt(st.nextToken()); // 시간
		
		int[][] map = new int[R][C];
		
		Queue<Dust> q = new LinkedList<>(); // 미세먼지 정보 저장
		
		int[] cleaner = new int[2]; // 공기청정기 위치 저장
		
		// map 입력
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기 위치 입력
				if(map[i][j] == -1) {
					cleaner[0] = i-1;
					cleaner[1] = i;
				}
			}
		}
		
		// T초만큼 반복
		for(int time=0; time<T; time++) {
			// 1단계 : 미세먼지 확산
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] > 0) {
						int spread = map[i][j]/5; // 확산 미세먼지 양
						int count = 0;
						
						// 미세먼지가 확산할 곳 4방탐색
						for(int k=0; k<4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							
							// 범위 내, 공기청정기 위치가 아닐 경우 확산
							if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
								q.add(new Dust(nx, ny, spread)); // 확산될 위치, 미세먼지의 양 저장
								count++;
							}
						}
						map[i][j] -= spread * count; // 확산된 만큼 미세먼지의 양 감소
					}
				}
			}
			
			// 확산된 모든 미세먼지 반영
			while(!q.isEmpty()) {
				Dust spreadedDust = q.poll();
				map[spreadedDust.x][spreadedDust.y] += spreadedDust.w;
			}
			
			// 2단계 공기청정기 작동
			// 위쪽 바람
			int nx = cleaner[0] - 1;
			int ny = 0;
			
			// 왼쪽 위 -> 공기청정기 방향 흡수
			while(nx-1 >= 0) {
				map[nx][ny] = map[nx-1][ny];
				nx--;
			}
			
			// 오른쪽 위 -> 왼쪽 위 방향 흡수
			while(ny+1 < C) {
				map[nx][ny] = map[nx][ny+1];
				ny++;
			}
			
			// 공기청정기의 오른쪽 위치 -> 오른쪽 위 방향 흡수
			while(nx+1 <= cleaner[0]) {
				map[nx][ny] = map[nx+1][ny];
				nx++;
			}
			
			// 공기청정기 위치 -> 오른쪽 방향 흡수
			while(ny-1 >= 1) {
				map[nx][ny] = map[nx][ny-1];
				ny--;
			}
			map[nx][ny] = 0; // 공기청정기에서 나오는 바람
			
			// 아래쪽 바람
			nx = cleaner[1] + 1;
			ny = 0;
			
			// 아래쪽 -> 공기청정기 방향 흡수
			while(nx+1 < R) {
				map[nx][ny] = map[nx+1][ny];
				nx++;
			}
			
			// 오른쪽 아래 -> 왼쪽 아래 방향 흡수
			while(ny+1 < C) {
				map[nx][ny] = map[nx][ny+1];
				ny++;
			}
			
			// 공기청정기의 오른쪽 위치 -> 오른쪽 아래 방향 흡수
			while(nx-1 >= cleaner[1]) {
				map[nx][ny] = map[nx-1][ny];
				nx--;
			}
			
			// 공기청정기 위치 -> 오른쪽 방향 흡수
			while(ny-1 >= 1) {
				map[nx][ny] = map[nx][ny-1];
				ny--;
			}
			map[nx][ny] = 0; // 공기청정기에서 나오는 바람
		}
		
		// 남아있는 미세먼지 합
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == -1) continue;
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}
