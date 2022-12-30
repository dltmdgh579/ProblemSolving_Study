import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819{

    static int N, max;
    static int[] A, selected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        selected = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        per(0);
        System.out.println(max);
    }

    public static void per(int cnt){
        if(cnt == N){
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(selected[i] - selected[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            selected[cnt] = A[i];
            visited[i] = true;
            per(cnt + 1);
            visited[i] = false;
        }
    }
}