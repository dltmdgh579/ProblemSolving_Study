import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

    static class Tomato{
        int x, y, z, count;
        public Tomato(int x, int y, int z, int count){
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }

    static int M, N, H, result;
    //상하좌우앞뒤
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] board;
    static boolean[][][] visited;
    static Queue<Tomato> q;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        q = new LinkedList<>();
        board = new int[N][M][H];

        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    // 익은 토마토 모두 큐에 저장
                    if(board[i][j][k] == 1){
                        q.offer(new Tomato(i, j, k, 0));
                    }
                }
            }
        }

        System.out.println(bfs());
        
    }
    public static int bfs(){
        while(!q.isEmpty()){
            Tomato t = q.poll();

            result = t.count;

            for(int i=0; i<6; i++){
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H){
                    if(board[nx][ny][nz] == 0){
                        q.offer(new Tomato(nx, ny, nz, t.count+1));
                        board[nx][ny][nz] = 1;
                    }
                }
            }
        }

        // 안익은 토마토 검사
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }
        return result;
    }
}
