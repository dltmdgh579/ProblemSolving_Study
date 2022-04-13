import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143 {
	
	// 상어 정보
	static class Shark{
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R, C, M, size;
	// 상하우좌
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};
	static Shark[][] map;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R+1][C+1];
		
		// 상어 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new Shark(r, c, s, d, z);
		}
		
		fishing();
		System.out.println(size);
	}
	public static void fishing() {
		// 낚시왕 오른쪽으로 한 칸씩 이동
		for(int i=1; i<=C; i++) {
			// 가장 가까운 상어 잡기
			catchShark(i);
			// 남아있는 상어 이동
			move();
		}
	}
	
	public static void catchShark(int i) {
		for(int j=1; j<=R; j++) {
			if(map[j][i] != null) {
				size += map[j][i].z;
				map[j][i] = null;
				break;
			}
		}
	}
	
	public static void move() {
		
		Shark[][] mapCopy = new Shark[R+1][C+1]; // 상어 이동 맵
		
		for(int j=1; j<=R; j++) {
			for(int k=1; k<=C; k++) {
				if(map[j][k] != null) {
					Shark curShark = map[j][k];
					int nx = curShark.r;
					int ny = curShark.c;
					
					// 상어 이동 최적화
					int speed = 0;
					if(curShark.d == 1 || curShark.d == 2) {
						speed = curShark.s%(R*2 - 2);							
					} else {
						speed = curShark.s%(C*2 - 2);
					}
					
					// 상어 이동 
					while(speed-- > 0) {
						int rowCheck = nx + dx[curShark.d];
						int colCheck = ny + dy[curShark.d];
						
						// 경계를 넘는 경우 방향 전환
						if(rowCheck == 0 || colCheck == C+1) {
							curShark.d += 1;
						}
						if(rowCheck == R+1 || colCheck == 0) {
							curShark.d -= 1;
						}
						nx += dx[curShark.d];
						ny += dy[curShark.d];
					}
					
					// 해당 위치에 상어가 있을 경우 크기 비교
					if(mapCopy[nx][ny] != null) {
						if(curShark.z > mapCopy[nx][ny].z) {
							mapCopy[nx][ny] = new Shark(nx, ny, curShark.s, curShark.d, curShark.z);
						}
					} else {
						mapCopy[nx][ny] = new Shark(nx, ny, curShark.s, curShark.d, curShark.z);
					}
				}
			}
		}
		// 모든 상어 이동한 맵을 기존 맵으로 갱신
		copy(mapCopy, map);
	}
	
	public static void copy(Shark[][] mapCopy, Shark[][] map) {
		for(int i=0; i<mapCopy.length; i++) {
			for(int j=0; j<mapCopy[0].length; j++) {
				map[i][j] = mapCopy[i][j];
			}
		}
	}
}
