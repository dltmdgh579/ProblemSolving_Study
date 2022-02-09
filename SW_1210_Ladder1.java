package _0209;

import java.util.Scanner;

public class SW_1210_Ladder1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int[][] ladder = new int[100][100];
			int pointX = 0;
			int pointY = 0;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) {
						pointX = i;
						pointY = j;
					}
				}
			}

			while(pointX != 0) {
				boolean flag = true;
				if(pointY - 1 >= 0 && ladder[pointX][pointY-1] == 1) {
					while(ladder[pointX][pointY-1] == 1) {
						pointY--;	
						if(ladder[pointX-1][pointY]==1) break;
					}
					flag = false;
				}
				if(pointY + 1 < 100 && ladder[pointX][pointY+1] == 1 && flag) {
					while(ladder[pointX][pointY+1] == 1) {
						pointY++;	
						if(ladder[pointX-1][pointY]==1) break;
					}
				}
				pointX--;
			}
			System.out.println("#" + tc + " " + pointY);
		}
	}
}
