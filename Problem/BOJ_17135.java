import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17135 {

	static class Point{
		int x, y; 
		boolean isKill;
		public Point(int x, int y, boolean isKill) {
			this.x = x;
			this.y = y;
			this.isKill = isKill;
		}
	}
	
	static int N, M, D, max = Integer.MIN_VALUE;
	static ArrayList<Point> p;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		
		// 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(max);
	}
	
	public static void comb(int cnt, int start) {
		// 궁수 배치 완료
		if(cnt == 3) {
			int[][] mapCopy = new int[N+1][M];
			copy(mapCopy, map);
			
			// 현재 궁수 배치로 제거한 적의 수
			int killCnt = gameStart(mapCopy);
			
			max = Math.max(max, killCnt);
			return;
		}
		
		// 궁수 배치
		for(int i=start; i<M; i++) {
			if(map[N][i] == 0) {
				map[N][i] = 2;
				comb(cnt + 1, i + 1);
				map[N][i] = 0;
			}
		}
	}

	public static int gameStart(int[][] map) {
		int kill = 0;
		
		// 1턴 : 궁수 shoot -> 적 move -> 남은 적 count
		while(true) {
			// 적 공격
			kill = shoot(p, map, kill);
			
			// 남은 적 이동
			move(map);
			
			// 남은 적 count
			int count = enemyCount(map);

			// map에 적이 없으면 종료
			if(count == 0) return kill;
		}
	}
	
	public static void copy(int[][] mapCopy, int[][] map) {
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
	}
	
	public static void move(int[][] map) {
		for(int i=N-1; i>=0; i--) {
			for(int j=M-1; j>=0; j--) {
				if(map[i][j] == 1) {
					int nx = i + 1;
					int ny = j;
					if(nx >= N) {
						map[i][j] = 0;
						continue;
					}
					map[nx][ny] = map[i][j];
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static int shoot(ArrayList<Point> p, int[][] map, int kill) {
		p = new ArrayList<>();
		for(int i=0; i<M; i++) {
			// 각각의 궁수마다 가장 가까운 적 탐색
			if(map[N][i] == 2) {
				boolean flag = false; // 공격할 적 유무 체크
				int min_dist = Integer.MAX_VALUE;
				int min_x = 999;
				int min_y = 999;
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						// 적 발견
						if(map[j][k] == 1) {
							int dist = Math.abs(j - N) + Math.abs(k - i);
							// 공격 거리 안
							if(dist <= D) {
								if(min_dist >= dist) {
									// 가장 왼쪽의 적으로
									if(min_dist == dist) {
										if(min_y < k) continue;
									}
									min_dist = dist;
									min_x = j;
									min_y = k;
									flag = true; // 공격할 적 확인
								}
							}
						}
					}
				}
				// 공격할 적이 있을 경우
				if(flag)
					p.add(new Point(min_x, min_y, true)); // 적 좌표 저장
			}
		}
		
		// 저장된 적 모두 제거
		for(int i=0; i<p.size(); i++) {
			if(p.get(i).isKill && map[p.get(i).x][p.get(i).y] == 1) {
				map[p.get(i).x][p.get(i).y] = 0;
				kill++;
			}
		}
		return kill;
	}
	
	public static int enemyCount(int[][] map) {
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) count++;
			}
		}
		return count;
	}
}
