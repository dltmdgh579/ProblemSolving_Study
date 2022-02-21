package _0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_Cipher {
	static int L, C;
	static char[] code, result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		code = new char[C]; // 암호 문자 종류
		result = new char[L]; // 가능성 있는 암호 조합
		
		st = new StringTokenizer(br.readLine());
		
		// 암호 문자 입력
		for(int i=0; i<C; i++) {
			code[i] = st.nextToken().charAt(0);
		}
		// 알파벳 정렬
		Arrays.sort(code);
		
		combination(0, 0);
	}
	public static void combination(int cnt, int start) {
		// L가지 암호 조합이 완성되었을 경우
		if(cnt == L) {
			int count1=0; // 모음 count
			int count2=0; // 자음 count
			
			// 모음, 자음 체크
			for(int i=0; i<L; i++) {
				char check = result[i];
				if(check == 'a' || check == 'e' || check == 'i' || check == 'o' || check == 'u') {
					count1++;
				} else count2++;
			}
			
			// 모음 한 개, 자음 두 개 이상이 아닐 경우
			if(count1 < 1 || count2 < 2) return;
			
			// 암호문 출력
			for(int i=0; i<L; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			return;
		}
		
		// 암호 조합
		for(int i=start; i<C; i++) {
			result[cnt] = code[i];
			combination(cnt+1, i+1);
		}
	}

}
