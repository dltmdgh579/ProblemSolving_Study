import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                board[i][j] = str.charAt(j);
            }
        }

        search(board, N);

        for(int i=0; i<N; i++){
            for(int j=1; j<N; j++){
                //세로
                if(board[j][i] != board[j-1][i]){
                    Character tmp = null;
                    tmp = board[j][i];
                    board[j][i] = board[j-1][i];
                    board[j-1][i] = tmp;
                    search(board, N);
                    board[j-1][i] = board[j][i];
                    board[j][i] = tmp;
                }
                //가로
                if(board[i][j] != board[i][j-1]){
                    Character tmp = null;
                    tmp = board[i][j];
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = tmp;
                    search(board, N);
                    board[i][j-1] = board[i][j];
                    board[i][j] = tmp;
                }
            }
        }
        System.out.println(count);
    }

    public static void search(char[][] board, int N){
        for(int i=0; i<N; i++){
            int count_col = 1;
            int count_row = 1;
            for(int j=1; j<N; j++){
                if(board[i][j] == board[i][j-1]){
                    count_col++;
                } else {
                    count_col = 1;
                }
                count = Math.max(count, count_col);

                if(board[j][i] == board[j-1][i]){
                    count_row++;
                } else {
                    count_row = 1;
                }
                count = Math.max(count, count_row);
            }
        }
    }
}
