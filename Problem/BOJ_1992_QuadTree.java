package _0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_QuadTree {

	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		map = new int[N][N];

		//입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		//압축
		compress(N, 0, 0);
		
		//출력
		System.out.println(sb.toString());

	}

	public static void compress(int size, int mx, int my) {

		// size 크기의 배열 요소 합 검사
		int sum = check(size, mx, my);

		// 배열 요소가 모두 0 또는 1일 경우
		if (sum == 0 || sum == size * size) {
			sb.append(sum/(size*size));
			return;
		}

		// 2분할
		int half = size / 2;

		sb.append("(");

		compress(half, mx, my); // 1사분면
		compress(half, mx, my + half); // 2사분면
		compress(half, mx + half, my); // 3사분면
		compress(half, mx + half, my + half); // 4사분면

		sb.append(")");
	}

	public static int check(int size, int mx, int my) {
		int sum = 0;
		// size 크기의 배열 요소 합 검사
		for (int i = mx; i < mx + size; i++) {
			for (int j = my; j < my + size; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

}
