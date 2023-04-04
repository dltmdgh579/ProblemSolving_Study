import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_3190 {
    static int N, K, L, time;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static Map<Integer, Character> dirMap = new HashMap<>();
    static ArrayList<int[]> snake = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 2;
        }
        
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);

            dirMap.put(X, C);
        }

        int nextIdx = 0;
        int curX = 1, curY = 1;
        int nx = dx[nextIdx], ny = dy[nextIdx];

        snake.add(new int[] {curX, curY});
        while(true){
            time++;

            curX += nx;
            curY += ny;

            if(check(curX, curY)) break;

            if(map[curX][curY] == 2){
                map[curX][curY] = 0;
                snake.add(new int[] {curX, curY});
            } else {
                snake.add(new int[] {curX, curY});
                snake.remove(0);
            }

            if(dirMap.containsKey(time)){
                char turnDir = dirMap.get(time);
                if(turnDir == 'L') {
                    nextIdx++;
                    if(nextIdx == 4) nextIdx = 0;
                    nx = dx[nextIdx];
                    ny = dy[nextIdx];
                } else {
                    nextIdx--;
                    if(nextIdx == -1) nextIdx = 3;
                    nx = dx[nextIdx];
                    ny = dy[nextIdx];
                }
            }
        }

        System.out.println(time);
    }

    public static boolean check(int curX, int curY){
        if(curX < 1 || curX > N || curY < 1 || curY > N) return true;

        for(int i=0; i<snake.size(); i++){
            if(snake.get(i)[0] == curX && snake.get(i)[1] == curY) return true;
        }

        return false;
    }
}
