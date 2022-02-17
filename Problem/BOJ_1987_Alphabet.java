package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_Alphabet {
	
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	static boolean[] check;
	static int R, C, max;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new boolean[26]; // 방문한 알파벳 체크
		
		// 입력
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// max값 초기화
		max = Integer.MIN_VALUE;
		
		// 좌측 상단부터 탐색
		go(0, 0, 0);
		System.out.println(max);
	}
	
	public static void go(int x, int y, int count) {
		// 한 칸 이동
		count++;
		check[map[x][y]-'A'] = true; // 현재 알파벳 체크
		
		// max값 갱신
		if(count > max) {
			max = count;
		}
		
		// 4방탐색
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < R && ny < C && !check[map[nx][ny]-'A']) {
				go(nx, ny, count);
			}
		}
		// 4방탐색 후 직전 칸으로 돌아가기 전 체크 해제
		check[map[x][y]-'A'] = false;
	}
}
