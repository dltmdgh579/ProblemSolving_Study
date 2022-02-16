package _0216;

import java.util.Scanner;

public class SW_6808_CardGame {
	static boolean[] isSelected; // 순열 방문 체크 
	static int[] gyu, in, cases;
	static int cnt1, cnt2;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			boolean[] check = new boolean[19];
			isSelected = new boolean[9];
			gyu = new int[9];
			in = new int[9];
			
			// 규영 카드 입력
			for(int i=0; i<9; i++) {
				gyu[i] = sc.nextInt();
				check[gyu[i]] = true; // 전체 카드 중 규영 카드 체크
			}
			
			// 인영 카드
			int tmp = 0;
			for(int i=1; i<check.length; i++) {
				if(!check[i]) in[tmp++] = i;
			}
			
			cases = new int[9]; // 인영 카드 순열 담는 배열
			cnt1 = cnt2 = 0; // 이긴 횟수 초기화
			permutation(0);
			System.out.println("#" + tc + " " + cnt1 + " " + cnt2);
		}
		
	}
	
	// 인영 카드 순열로 모든 경우 비교
	public static void permutation(int cnt) {
		
		if(cnt == 9) {
			// 점수 초기화
			int sum1 = 0;
			int sum2 = 0;
			// 카드 숫자가 더 큰 사람에게 점수 추가
			for(int i=0; i<9; i++) {
				if(gyu[i] > cases[i]) sum1 += gyu[i] + cases[i];
				else sum2 += gyu[i] + cases[i];
			}
			
			if(sum1>sum2) cnt1++; // 규영 승리
			else if (sum2>sum1) cnt2++; // 인영 승리
			return;
		}
		
		// 순열 생성
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			cases[cnt] = in[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
}
