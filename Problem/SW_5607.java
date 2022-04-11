package _0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5607 {
	
	static int N, R;
	static int mod = 1234567891;
	static long[] factorial;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 팩토리얼 저장
		factorial = new long[1000001];
		factorial[0] = 1;
		
		for(int i=1; i<1000001; i++) {
			factorial[i] = (factorial[i-1] * i)%mod;
		}
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long top = (factorial[N])%mod;
			long bottom = (factorial[N-R] * factorial[R])%mod;

			bottom = pow(bottom, mod-2);
			
			System.out.println("#" + tc + " " + ((top * bottom)%mod));
		}
	}
	public static long pow(long num, int p) {
		// 지수가 0이면 1 리턴
		if(p==0) {
			return 1;
		}
		
		// 분할정복
		long half = pow(num, p/2);
		
		if(p%2 == 0) {
			return ((half%mod) * (half%mod))%mod;
		} else {
			return (((half * num) % mod) * (half%mod))%mod;
		}
	}

}
