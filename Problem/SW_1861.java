package _0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1861 {

	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, maxMove, minPoint;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			// 공간 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			maxMove = Integer.MIN_VALUE;
			minPoint = Integer.MAX_VALUE;

			// 첫 번째 방 부터 마지막 방까지 dfs
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, map[i][j]);
				}
			}
			System.out.println("#" + tc + " " + minPoint + " " + maxMove);
		}
	}

	public static void dfs(int x, int y, int count, int start) {
		// 최대 이동거리, 출발 지점 갱신
		if (count > maxMove) {
			maxMove = count;
			minPoint = start;
		}
		// 최대 이동거리가 같은 방 중 가장 작은 방
		if (count == maxMove)
			minPoint = Math.min(minPoint, start);
		
		// 4방탐색
		for (int j = 0; j < 4; j++) {
			int nx = x + dx[j];
			int ny = y + dy[j];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == map[x][y] + 1) {
				dfs(nx, ny, count + 1, start);
			}
		}
	}
}
