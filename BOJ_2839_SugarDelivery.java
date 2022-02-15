package _0215;

import java.util.Scanner;

public class BOJ_2839_SugarDelivery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		
		while(true) {
			// 5kg으로 나눠질 경우 5kg으로 전부 배달
			if(N%5 == 0) {
				System.out.println(count + N/5);
				break;
			}
			// 5kg으로 나눠지지 않을 경우 3kg씩 배달
			else{
				N -= 3;
				count++;
			}
			// 그 외
			if(N<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
