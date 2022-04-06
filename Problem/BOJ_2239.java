import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239 {

	static int[][] board;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				board[i][j] = str.charAt(j)-'0';
			}
		}
		
		sudoku(0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean sudoku(int cnt) {
		// 스도쿠 완성
		if(cnt == 81) {
			return true;
		}
		
		int x = cnt/9;
		int y = cnt%9;
		
		if(board[x][y] != 0) {
			if(sudoku(cnt + 1)) return true;
		}
		else {
			for(int k=1; k<=9; k++) {
				if(isAvailable(x, y, k)) {
					board[x][y] = k;
					if(sudoku(cnt+1)) {
						return true;
					}
					board[x][y] = 0;
				}
			}
		}
		return false;
	}

	public static boolean isAvailable(int r, int c, int num) {
		// 행, 열 체크
		for(int i=0; i<9; i++) {
			if(board[i][c] == num || board[r][i] == num) return false;
		}
		
		// 3 x 3 사각형 체크
		int sr = r/3 * 3;
		int sc = c/3 * 3;
		for(int i=sr; i<sr + 3; i++) {
			for(int j=sc; j<sc + 3; j++) {
				if(board[i][j] == num) return false;
			}
		}
		return true;
	}

}
