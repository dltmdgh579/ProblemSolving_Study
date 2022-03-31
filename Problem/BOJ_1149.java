import java.util.Scanner;

public class BOJ_1149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] rgb = new int[N][3];
		
		// 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				rgb[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<N; i++) {
			rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]); // 현재 집의 색이 R이고, 현재까지의 최소비용
			rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]); // 현재 집의 색이 G이고, 현재까지의 최소비용
			rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]); // 현재 집의 색이 B이고, 현재까지의 최소비용
		}
		
		System.out.println(Math.min(Math.min(rgb[N-1][0], rgb[N-1][1]), rgb[N-1][2]));
	}
}
