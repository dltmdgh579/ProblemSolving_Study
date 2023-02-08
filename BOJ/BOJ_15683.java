import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int N, M;
    static int[][] map, copy_map;
    static ArrayList<CCTV> cctv_list;
    static int[] selected_dir;
    static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        cctv_list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6){
                    cctv_list.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        selected_dir = new int[cctv_list.size()];
        per(0);
        
        System.out.println(answer);

    }

    public static void per(int cnt){
        if(cnt == cctv_list.size()){
            copy_map = new int[N][M];
            for(int i=0; i<map.length; i++){
                System.arraycopy(map[i], 0, copy_map[i], 0, map[i].length);
            }

            for(int i=0; i<cctv_list.size(); i++){
                direction(cctv_list.get(i), selected_dir[i]);
            }

            getCount();
            return;
        }

        for(int i=0; i<4; i++){
            selected_dir[cnt] = i;
            per(cnt + 1);
        }
    }

    public static void direction(CCTV cctv, int d){
        int cctv_num = cctv.num;

        if(cctv_num == 1) {
			if(d == 0) watch(cctv, 0);
			else if(d == 1) watch(cctv, 1);
			else if(d == 2) watch(cctv, 2); 
			else if(d == 3) watch(cctv, 3);
		} else if(cctv_num == 2) {
			if(d == 0 || d == 2) {
				watch(cctv, 0); watch(cctv, 2);
			} else {
				watch(cctv, 1); watch(cctv, 3);
			}
		} else if(cctv_num == 3) {
			if(d == 0) {
				watch(cctv, 0);
				watch(cctv, 1);
			} else if(d == 1) { 
				watch(cctv, 1); 
				watch(cctv, 2);
			} else if(d == 2) { 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) { 
				watch(cctv, 0);
				watch(cctv, 3);
			}
		} else if(cctv_num == 4) {
			if(d == 0) {
				watch(cctv, 0);
				watch(cctv, 1);
				watch(cctv, 3);
			} else if(d == 1) {
				watch(cctv, 0);
				watch(cctv, 1);
				watch(cctv, 2);
			} else if(d == 2) {
				watch(cctv, 1);
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) {
				watch(cctv, 0);
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if(cctv_num == 5) {
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}

    }

    public static void watch(CCTV cctv, int d){
        Queue<CCTV> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(cctv);
        visited[cctv.r][cctv.c] = true;

        while(!q.isEmpty()){
            int nx = q.peek().r + dx[d];
            int ny = q.poll().c + dy[d];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && copy_map[nx][ny] != 6){
                if(copy_map[nx][ny] == 0){
                    copy_map[nx][ny] = -1;
                    q.add(new CCTV(nx, ny, cctv.num));
                } else {
                    q.add(new CCTV(nx, ny, cctv.num));
                }
            }
        }

    }

    public static void getCount(){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy_map[i][j] == 0){
                    count++;
                }
            }
        }
        answer = Math.min(answer, count);
    }

    static class CCTV{
        int r, c, num;
        public CCTV(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
