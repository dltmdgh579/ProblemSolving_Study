import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1767 {

	static class Core{
		int x, y;
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, map[][], minWire, maxCore;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1}; // 상 하 좌 우 델타
	static List<Core> mapList; // 코어 위치를 담을 리스트
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			mapList = new ArrayList<>();
			for( int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int in = Integer.parseInt(st.nextToken());
					// 코어일 경우
					if( in == 1) {
						map[i][j] = in;
						// 가장자리 코어일 경우
						if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
						mapList.add(new Core(i,j));
					}
				}
			}

			minWire = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			dfs(0, 0, 0);

			System.out.println("#" + test_case + " " + minWire);
		}

	}
	
	private static void dfs(int idx, int coreCnt, int wireCnt) {
		// 모든 코어 점검 후
		if(idx == mapList.size()) {
			// 최대한 많은 코어
			if(maxCore < coreCnt) { 
				maxCore = coreCnt;
				minWire = wireCnt;
			// 최소의 전선 길이 합
			} else if( maxCore == coreCnt) {
				minWire = Math.min(wireCnt, minWire);
			}
			return;
		}
		
		// 현재 코어 위치
		int x = mapList.get(idx).x;
		int y = mapList.get(idx).y;

		for( int dir = 0; dir < 4; dir++) {
			int count = 0;
			int nx = x;
			int ny = y;

			while(true) {
				nx += dx[dir];
				ny += dy[dir];
				
				// 가장자리까지 도달할 경우 - 전선 연결 가능
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) break;
				
				// 코어 혹은 전선이 존재할 경우 - 전선 연결 불가능 - count값 초기화
				if(map[nx][ny] != 0) {
					count = 0;
					break;
				}
				count++;
			}

			int fill_x = x;
			int fill_y = y;

			// 전선 설치
			for( int i = 0; i < count; i++) {
				fill_x += dx[dir];
				fill_y += dy[dir];
				map[fill_x][fill_y] = -1;
			}

			// 전선을 연결할 수 없는 경우
			if(count == 0) dfs(idx+1, coreCnt, wireCnt);
			// 전선을 연결할 수 있는 경우
			else {
				// 전원을 연결한 코어 + 1, 전선 길이 + count
				dfs(idx+1, coreCnt+1, wireCnt+count);

				// 전선 회수
				fill_x = x;
				fill_y = y;
				for( int i = 0; i < count; i++) {
					fill_x += dx[dir];
					fill_y += dy[dir];
					map[fill_x][fill_y] = 0;
				}
			}
		}
	}

}
