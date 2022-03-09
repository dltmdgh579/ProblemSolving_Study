import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580{
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       map = new int[9][9];

        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int row, int col){
        if(col == 9){
            dfs(row+1, 0);
            return;
        }

        if(row == 9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            return;
        }

        if(map[row][col] == 0){
            for(int i=1; i<=9; i++){
                if(check(row, col, i)){
                    map[row][col] = i;
                    dfs(row, col+1);
                }
            }
            map[row][col] = 0;
            return;
        }
        dfs(row, col+1);
    }

    public static boolean check(int row, int col, int value){
        for(int i=0; i<9; i++){
            if(map[row][i] == value){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(map[i][col] == value){
                return false;
            }
        }

        int div_row = row/3 * 3;
        int div_col = col/3 * 3;

        for(int i=div_row; i<div_row+3; i++){
            for(int j=div_col; j<div_col+3; j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}