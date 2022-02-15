package _0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2805_Crop {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<str.length(); j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			int sum = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=N/2 - i; j<N/2 + 1 + i; j++) {
					sum += arr[i][j];
				}
			}
			for(int i=N/2; i<N; i++) {
				for(int j=i - N/2; j<N - i + N/2; j++) {
					sum += arr[i][j];
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		
	}

}
