package _0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4012_chef {
	static int[][] table;
	static boolean[] check;
	static int N, min;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			table = new int[N][N]; // 시너지 정보 테이블
			check = new boolean[N]; // 사용한 재료 체크
			
			// 시너지 정보 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			combination(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void combination(int cnt, int start) {
		// 식재료 N/2를 모두 골랐을 때
		if(cnt == N/2) {
			// A, B 초기화
			int A = 0;
			int B = 0;
			
			// 시너지 계산
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 방문한 곳을 A 음식으로 계산
					if(check[i] && check[j]) {
						A += table[i][j];
					}
					// 방문하지 않은 곳 B
					else if(!check[i] && !check[j]) {
						B += table[i][j];
					}
				}
			}
			// 최솟값 갱신
			min = Math.min(min, Math.abs(A-B));
		}
		
		// 음식 재료 선택
		for(int i=start; i<N; i++) {
			check[i] = true;
			combination(cnt+1, i+1);
			check[i] = false;
		}
	}
}
