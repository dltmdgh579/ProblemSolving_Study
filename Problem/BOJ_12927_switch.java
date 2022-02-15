package _0209;

import java.util.Scanner;

public class BOJ_12927_switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		char[] arr = new char[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		int count = 0;
		int mul = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(arr[i] == 'N') continue;
			else {
				count++;
				mul = i+1;
			}
			
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
