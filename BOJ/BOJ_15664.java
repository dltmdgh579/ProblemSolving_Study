import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15664{

    static int N, M;
    static int[] A, selected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        comb(0, 0);
    }

    public static void comb(int start, int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        int num = 0;
        for(int i=start; i<N; i++){
            if(visited[i] || num == A[i]) continue;
            num = A[i];
            selected[cnt] = A[i];
            visited[i] = true;
            comb(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}