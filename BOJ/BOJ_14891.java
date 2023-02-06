import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] gears;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new int[4][8];

        for(int i=0; i<4; i++){
            String status = br.readLine();
            for(int j=0; j<8; j++){
                gears[i][j] = status.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            work(idx-1, dir);

        }

        int score = 0;

        for(int i=0; i<4; i++){
            if(gears[i][0] == 1) score += (int) Math.pow(2, i);  
        }

        System.out.println(score);
    }

    public static void work(int idx, int dir){
        left(idx-1, -dir);
        right(idx+1, -dir);
        rotation(idx, dir);
    }

    public static void left(int idx, int dir){
        if(idx < 0) return;
        if(gears[idx][2] == gears[idx+1][6]) return;
        left(idx-1, -dir);
        rotation(idx, dir);
    }

    public static void right(int idx, int dir){
        if(idx > 3) return;
        if(gears[idx][6] == gears[idx-1][2]) return;
        right(idx+1, -dir);
        rotation(idx, dir);
    }

    public static void rotation(int idx, int dir){
        if(dir == 1){
            int tmp = gears[idx][7];
            for(int i=7; i>0; i--){
                gears[idx][i] = gears[idx][i-1];
            }
            gears[idx][0] = tmp;
        } else {
            int tmp = gears[idx][0];
            for(int i=0; i<7; i++){
                gears[idx][i] = gears[idx][i+1];
            }
            gears[idx][7] = tmp;
        }
    }
}
