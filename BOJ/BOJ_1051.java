import java.util.*;
import java.io.*;
public class BOJ_1051 {
    static int N, M, max = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                check(i, j, board[i][j]);
            }
        }

        if(max == 0) max = 1;
        System.out.println(max);
    }

    public static void check(int row, int col, int num){
        //행체크
        for(int i=M-1; i>col; i--){
            if(num == board[row][i]){
                int len = i - col;
                if(row + len >= N) continue;
                if(board[row + len][col] != num) continue;
                if(board[row + len][col + len] != num) continue;
                max = Math.max(max, (len+1)*(len+1));
            }            
        }
    }
}
