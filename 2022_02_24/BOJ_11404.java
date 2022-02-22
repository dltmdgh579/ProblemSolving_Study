import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404{
    static int[][] map;
    static int n, m, INF = 10000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        // infinity 값으로 초기화
        for(int[] map : map){
            Arrays.fill(map, INF);
        }

        // 비용 입력
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }

        floyd();

        // 시작, 도착 도시가 같은 경우 0으로 초기화
        for(int i=1; i<=n; i++){
            map[i][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] == INF) map[i][j] = 0;
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    //플로이드 와샬
    public static void floyd(){
        //거쳐가는 도시
        for(int k=1; k<=n; k++){
            // 출발 도시
            for(int i=1; i<=n; i++){
                if(i == k) continue;
                //도착 도시
                for(int j=1; j<=n; j++){
                    if(j == k || j == i) continue;
                    if(map[i][k] != INF && map[k][j] != INF && map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
    }
}