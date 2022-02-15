package _0215;

import java.util.Arrays;
import java.util.Scanner;

public class OL_1828_refrigerator {
	
	// 화학 물질 보관 온도 저장
	static class Chemicals implements Comparable<Chemicals>{
		int min, max;

		public Chemicals(int min, int max) {
			this.min = min;
			this.max = max;
		}

		// 최고 보관 온도 오름차순
		@Override
		public int compareTo(Chemicals o) {
			return this.max - o.max;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Chemicals[] chem = new Chemicals[N];
		for(int i=0; i<N; i++) {
			chem[i] = new Chemicals(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(chem); // 최고 보관 온도 오름차순 정렬
		
		int refrigerator = 1; // 처음 냉장고 수 1개
		
		int markMax = chem[0].max; // 첫번째 화학물질 최고 보관온도 마크
		
		for(int i=1; i<N; i++) {
			if(markMax < chem[i].min) { // 최저 보관온도가 마크값보다 클 경우
				refrigerator++; // 냉장고 수 1 증가
				markMax = chem[i].max; // 최고 보관온도 마크값 갱신
			}
		}
		System.out.println(refrigerator);
	}
}
