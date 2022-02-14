package _0214;

import java.util.Scanner;

public class BOJ_3040_SnowWhite {
	
	static int[] arr, numbers;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		numbers = new int[7];
		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0,0);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0; i<cnt; i++) {
				sum += numbers[i];
			}
			if(sum == 100) {
				for(int i=0; i<cnt; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			numbers[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
}
