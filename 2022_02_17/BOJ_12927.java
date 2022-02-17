import java.util.Scanner;

public class BOJ_12927 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		char[] arr = new char[str.length()];
		
		// 입력
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		int count = 0;
		int mul = 0;
		
		for(int i=0; i<str.length(); i++) {
			// 스위치가 켜져 있을 경우만 고려
			if(arr[i] == 'N') continue;
			else {
				count++; // 스위치 작동 횟수
				mul = i+1; // 배수
			}
			
			// 첫 스위치가 켜져 있을 경우 모든 배수 반전
			for(int j=mul-1; j<str.length(); j+=mul) {
				arr[j] = arr[j]=='Y'?'N':'Y';
			}
			
			for(int j=0; j<str.length(); j++) {
				if(arr[j] == 'N') continue;
				else {
					break;
				}
			}
		}
		System.out.println(count);
	}
}
