package _0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_Food {
	static int[] arrS, arrB;
	static int N, min;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arrS = new int[N];
		arrB = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arrS[i] = S;
			arrB[i] = B;
		}
		min = Integer.MAX_VALUE;
		subSet(0, 1, 0);
		System.out.println(min);
		
	}
	public static void subSet(int cnt, int S, int B) {
		if(cnt == N) {
			return;
		}
		// 신맛 쓴맛 차이 갱신
		if(Math.abs((arrS[cnt] * S) - (arrB[cnt] + B)) < min)
			min = Math.abs((arrS[cnt] * S) - (arrB[cnt] + B));
		
		subSet(cnt+1, S * arrS[cnt], B + arrB[cnt]); // 재료 선택
		subSet(cnt+1, S, B); // 재료 비선택
	}

}
