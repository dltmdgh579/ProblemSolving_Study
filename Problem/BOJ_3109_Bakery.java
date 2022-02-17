package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_Bakery {
	
	static char[][] map;
	static boolean[][] visit;
	static int R, C, count;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C]; // 방문 체크
		
		// 입력
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 첫 번째 행부터 마지막 행까지 파이프라인 설치
		for(int i=0; i<R; i++) {
			go(i, 0);
		}
		System.out.println(count);
		
	}
	
	public static boolean go(int row, int col) {
		// 마지막 열 도착
		if(col == C-1) {
			count++;
			return true; // 마지막 열에 도착했을 경우 true 리턴
		}
		
		// 오른쪽 위
		if(row-1 >= 0 && col+1 < C) {
			if(map[row-1][col+1] == '.' && !visit[row-1][col+1]) {
				visit[row][col] = true; // 방문
				if(go(row-1, col+1)) return true; // 해당 루트가 마지막 열에 도착했으면 가지치기 방지
			}
		}
		
		// 오른쪽
		if(col+1 < C) {
			if(map[row][col+1] == '.' && !visit[row][col+1]) {
				visit[row][col] = true;
				if(go(row, col+1)) return true;
			}
		}
		
		// 오른쪽 아래
		if(row+1 < R && col+1 < C) {
			if(map[row+1][col+1] == '.' && !visit[row+1][col+1]) {
				visit[row][col] = true;
				if(go(row+1, col+1)) return true;
			}
		}
		return false;
	}
}
