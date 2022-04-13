import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_4013 {
	
	// 회전되는 자석 정보
	static class Rotation{
		int magNum, dir;
		public Rotation(int magNum, int dir) {
			this.magNum = magNum;
			this.dir = dir;
		}
	}

	static int K, score;
	static int[][] magnet;
	static ArrayList<Rotation> rotation;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			K = Integer.parseInt(br.readLine());
			
			magnet = new int[4][8];
			rotation = new ArrayList<Rotation>();
			
			// 입력
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 회전정보 입력
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int magNum = Integer.parseInt(st.nextToken());
				int rotationDir = Integer.parseInt(st.nextToken());
				rotation.add(new Rotation(magNum-1, rotationDir));
			}
			
			rotate();
			System.out.println("#" + tc + " " + score);
		}
	}
	public static void rotate() {
		// 차례대로 회전
		for(Rotation r : rotation) {
			int[] temp = new int[5]; // 회전될 자석의 회전방향 저장
			
			int cur = r.magNum;
			int next = r.magNum;
			int nextDir = r.dir;
			temp[cur] = r.dir;
			
			// 오른쪽 자석 검사
			while(true) {
				next++;
				if(next > 3) break;
				// 붙어있는 날의 자성이 같을 경우
				if(magnet[cur][2] == magnet[next][6]) break;
				
				nextDir *= (-1);
				temp[next] = nextDir;
				cur++;
			}
			
			cur = r.magNum;
			next = r.magNum;
			nextDir = r.dir;
			
			// 왼쪽 자석 검사
			while(true) {
				next--;
				if(next < 0) break;
				// 붙어있는 날의 자성이 같을 경우
				if(magnet[cur][6] == magnet[next][2]) break;
				
				nextDir *= (-1);
				temp[next] = nextDir;
				cur--;
			}
			
			// 회전
			for(int i=0; i<4; i++) {
				// 반시계 방향
				if(temp[i] == -1) {
					int tmp = magnet[i][0];
					for(int j=0; j<7; j++) {
						magnet[i][j] = magnet[i][j+1];
					}
					magnet[i][7] = tmp;
				}
				// 시계 방향
				else if(temp[i] == 1) {
					int tmp = magnet[i][7];
					for(int j=7; j>0; j--) {
						magnet[i][j] = magnet[i][j-1];
					}
					magnet[i][0] = tmp;
				}
			}
		}
		
		// 점수 계산
		score = 0;
		for(int i=0; i<4; i++) {
			if(magnet[i][0] == 1) score += Math.pow(2, i);
		}
	}

}
