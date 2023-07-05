import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {
    static int N, max;
    static int[][] board;
    static String[] dir = {"up", "down", "left", "right"};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.println(max);
    }
    
    public static void dfs(int cnt){
        if(cnt == 5){
            findMax();
            return;
        }

        int[][] copy = new int[N][N];
        for(int i=0; i<N; i++){
            copy[i] = board[i].clone();
        }

        for(int i=0; i<4; i++){
            move(dir[i]);
            dfs(cnt+1);
            for(int a=0; a<N; a++){
                board[a] = copy[a].clone();
            }
        }
    }

    public static void move(String dir){
        if(dir.equals("up")){
            for(int i=0; i<N; i++){
                int index = 0;
                int block = 0;
                for(int j=0; j<N; j++){
                    if(board[j][i] != 0){
                        if(block == board[j][i]){
                            board[index-1][i] = block * 2;
                            board[j][i] = 0;
                            block = 0;
                        }
                        else {
                            block = board[j][i];
                            board[j][i] = 0;
                            board[index][i] = block;
                            index++;
                        }
                    }
                }
            }
        }
        if(dir.equals("down")){
            for(int i=0; i<N; i++){
                int index = N-1;
                int block = 0;
                for(int j=N-1; j>=0; j--){
                    if(board[j][i] != 0){
                        if(block == board[j][i]){
                            board[index+1][i] = block * 2;
                            board[j][i] = 0;
                            block = 0;
                        }
                        else {
                            block = board[j][i];
                            board[j][i] = 0;
                            board[index][i] = block;
                            index--;
                        }
                    }
                }
            }
        }
        if(dir.equals("left")){
            for(int i=0; i<N; i++){
                int index = 0;
                int block = 0;
                for(int j=0; j<N; j++){
                    if(board[i][j] != 0){
                        if(block == board[i][j]){
                            board[i][index-1] = block * 2;
                            board[i][j] = 0;
                            block = 0;
                        }
                        else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        }
        if(dir.equals("right")){
            for(int i=0; i<N; i++){
                int index = N-1;
                int block = 0;
                for(int j=N-1; j>=0; j--){
                    if(board[i][j] != 0){
                        if(block == board[i][j]){
                            board[i][index+1] = block * 2;
                            board[i][j] = 0;
                            block = 0;
                        }
                        else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        }
    }

    public static void findMax(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                max = Math.max(max, board[i][j]);
            }
        }
    }
}
